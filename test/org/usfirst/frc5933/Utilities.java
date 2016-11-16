package org.usfirst.frc5933;

import edu.wpi.first.wpilibj.Resource;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import jaci.openrio.toast.core.ToastBootstrap;
import jaci.openrio.toast.core.ToastConfiguration;
import jaci.openrio.toast.core.io.usb.USBMassStorage;
import jaci.openrio.toast.core.loader.ClassPatcher;
import jaci.openrio.toast.core.loader.RobotLoader;
import jaci.openrio.toast.core.script.js.JavaScript;
import jaci.openrio.toast.core.security.ToastSecurityManager;
import jaci.openrio.toast.core.shared.GlobalBlackboard;
import jaci.openrio.toast.core.thread.Async;
import jaci.openrio.toast.lib.crash.CrashHandler;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.log.SysLogProxy;
import jaci.openrio.toast.lib.module.ModuleConfig;
import jaci.openrio.toast.lib.profiler.Profiler;
import jaci.openrio.toast.lib.profiler.ProfilerSection;
import jaci.openrio.toast.lib.state.LoadPhase;

import java.io.File;

public class Utilities {

    private static ProfilerSection profiler;
    private static boolean setUpIsDone = false;

    /**
     * Toast Bootstrap in a function. This is very helpful for unit testing.
     */
    public static void startToast() {
        if (setUpIsDone) {
            return;
        }
        
        Thread main_thread = Thread.currentThread();
        Thread watch_init_thread = new Thread(() -> {
            try {
                Thread.sleep(2 * 60 * 1000);
                if (LoadPhase.currentPhase != LoadPhase.COMPLETE) {
                    System.err.println("[ ERROR ] Toast is taking over 2 minutes to initiate. This is not normal. Following is " +
                            "a full detailed list of where each thread is in its execution. If you are seeing this message, " +
                            "please notify the developers on the Toast API Main Repository (http://github.com/Open-RIO/ToastAPI");
                    System.err.println("\tMAIN Thread:");
                    for (StackTraceElement element : main_thread.getStackTrace()) {
                        System.err.println("\t\tat " + element);
                    }

                    Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> {
                        System.err.println("\tThread: '" + thread.getName() + "' priority: " + thread.getPriority() + " group: '" + thread.getThreadGroup().getName() + "'");
                        for (StackTraceElement element : stackTraceElements) {
                            System.err.println("\t\tat " + element);
                        }
                    });
                }
            } catch (InterruptedException ignored) {
            }
        });
        watch_init_thread.start();

        Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 2);      // Slightly above normal priority, but below maximum priority.
        ToastBootstrap.startTimeNS = System.nanoTime();
        ToastBootstrap.startTimeMS = System.currentTimeMillis();
        profiler = Profiler.INSTANCE.section("Setup");
        JavaScript.startLoading();
        profiler.start("ParseArgs");
        ToastBootstrap.toastHome = new File("run/gradle/test/toast/").getAbsoluteFile();
        ToastBootstrap.robotHome = new File("run/gradle/test/").getAbsoluteFile();

        ToastBootstrap.toastHome.mkdirs();

        LoadPhase.BOOTSTRAP.transition();

        profiler.start("Logger");
        SysLogProxy.init();
        profiler.stop("Logger");
        profiler.start("Crash");
        CrashHandler.init();
        profiler.stop("Crash");

        profiler.start("Misc");
        ToastBootstrap.toastLogger = new Logger("Toast", Logger.ATTR_DEFAULT);
        new GlobalBlackboard();
        profiler.stop("Misc");

        try {
            Thread.sleep(20);       // To avoid splash screen flush racing
        } catch (InterruptedException ignored) { }

        LoadPhase.CORE_PREINIT.transition();
        RobotLoader.preinit(Profiler.INSTANCE.section("RobotLoader"));

        LoadPhase.CORE_INIT.transition();
        RobotLoader.initCore(Profiler.INSTANCE.section("RobotLoader"));

        ModuleConfig.init();

        LoadPhase.PRE_INIT.transition();
        USBMassStorage.init();
        profiler.start("Configuration");
        ToastConfiguration.init();
        profiler.stop("Configuration");
        profiler.start("ThreadPool");
        Async.init();
        profiler.stop("ThreadPool");

        ClassPatcher classLoader = new ClassPatcher();
        classLoader.identifyPatches(true);

        LoadPhase.INIT.transition();
        RobotLoader.postCore(Profiler.INSTANCE.section("RobotLoader"));

        profiler.start("WPILib");
        RobotBase.initializeHardwareConfiguration();
        UsageReporting.report(FRCNetworkCommunicationsLibrary.tResourceType.kResourceType_Language, FRCNetworkCommunicationsLibrary.tInstances.kLanguage_Java);
        LoadPhase.COMPLETE.transition();

        setUpIsDone = true;
    }

    public static void initToast() {
    }

    public static void shutdownToast() {
//        Async.INSTANCE.finish();
        Resource.restartProgram();
    }
}
