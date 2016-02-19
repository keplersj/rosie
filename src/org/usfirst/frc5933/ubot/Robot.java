// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5933.ubot.commands.ArcadeDrive;
import org.usfirst.frc5933.ubot.commands.DeliverBallToLowerWindow;
import org.usfirst.frc5933.ubot.subsystems.*;

/**
 * The entry point for the Robot source code. Ran by the Java Virtual Machine installed on the RoboRIO.
 * This class contains the methods ran during the modes of driving; autonomous, teleoperation, etc.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command arcadeDrive;
    private static RiptServer server;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Power power;
    public static Arm arm;
    public static Sensors sensors;
    public static BallGrabberSubsystem ballGrabberSubsystem;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private BuiltInAccelerometer accel = new BuiltInAccelerometer();
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        RobotMap.init();
        initDashboardInput();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        power = new Power();
        arm = new Arm();
        sensors = new Sensors();
        ballGrabberSubsystem = new BallGrabberSubsystem();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new DeliverBallToLowerWindow();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    
        arcadeDrive = new ArcadeDrive();
               
        SmartDashboard.putNumber("Degrees for turning", 1);
        SmartDashboard.putNumber("Inches for driving", 1);

        server = RiptServer.getInstance();
        server.setQuality(100);
        server.setSize(0);
        server.startAutomaticCapture("cam0");
    }

    /**
     * Initializes the Starting Values on the SmartDashboard, so not to create a Null Pointer.
     */
    public void initDashboardInput() {
        SmartDashboard.putNumber("Autonomous Starting Position", 0);
        SmartDashboard.putNumber("Autonomous Barrier Number", 0);
        SmartDashboard.putNumber("Autonomous Lower Window Position", 0);
    }

   static public void toggleCamera() {
	   RiptServer.stop();
	   String cameraName = "cam0";
	   if (server.getCameraName().equals("cam0")) {
		   cameraName = "cam1";
	   }
       server = RiptServer.getInstance();
       server.setQuality(100);
       server.setSize(0);
       server.startAutomaticCapture(cameraName);
	   
	   // server.startAutomaticCapture("cam1");
	   // TODO: Ok I took a stab at changing the camera view as well, and it is a pain in the ass.
	   // I looked at the CameraFeed class, and after playing around a little while I came to the 
	   // conclusion that we may want to take a different approach and derive/recreate out own 
	   // CameraService class. The server thread
	   // in that class is the thang we want to shutdown, but some clown at wpi decided to hard
	   // code some "while true loops" that can never be stopped.
	}
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit() {
        oi.getXBoxJoystick().setRumble(RumbleType.kLeftRumble, 0);
        oi.getXBoxJoystick().setRumble(RumbleType.kRightRumble, 0);
        oi.getXBoxJoystick2().setRumble(RumbleType.kLeftRumble, 0);
        oi.getXBoxJoystick2().setRumble(RumbleType.kRightRumble, 0);
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
 
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        rumbleInYourPants();
        turnSpindleIfNeeded();
        if (arcadeDrive != null) arcadeDrive.start();

    }

    public void moveArmIfNeeded() {
        if (Robot.oi.getXBoxJoystick().getRawButton(5)) {
        	Robot.arm.joystickMove(false);
        }
        if (Robot.oi.getXBoxJoystick2().getRawButton(5)) {
        	Robot.arm.joystickMove(true);
        }
    }
    
    public void turnSpindleIfNeeded() {
    	if (Robot.oi.getAButton().get() || Robot.oi.getAButton2().get()) {
    		Robot.ballGrabberSubsystem.runForward();
    	} else if (Robot.oi.getBButton().get() || Robot.oi.getBButton2().get()) {
    		Robot.ballGrabberSubsystem.runBackward();
    	} else {
    		Robot.ballGrabberSubsystem.stop();
    	}
    }
    
    
    /**
     * Takes the Z Axis of the RoboRIO accelerometer, and passes it to the Joystick for haptic feedback of the robot.
     */
    public void rumbleInYourPants() {
        double accel_z = accel.getZ();

        Robot.oi.getXBoxJoystick().setRumble(RumbleType.kLeftRumble, (float) Math.abs(accel_z - 1));
        Robot.oi.getXBoxJoystick().setRumble(RumbleType.kRightRumble, (float) Math.abs(accel_z - 1));
        Robot.oi.getXBoxJoystick2().setRumble(RumbleType.kLeftRumble, (float) Math.abs(accel_z - 1));
        Robot.oi.getXBoxJoystick2().setRumble(RumbleType.kRightRumble, (float) Math.abs(accel_z - 1));
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
