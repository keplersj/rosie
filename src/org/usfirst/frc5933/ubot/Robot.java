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
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import jaci.openrio.toast.lib.module.IterativeModule;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.commands.*;
import org.usfirst.frc5933.ubot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeModule {
    Command autonomousCommand;
    Command arcadeDrive;
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static Power power;
    public static Arm arm;
    public static Sensors sensors;
    public static BallGrabberSubsystem ballGrabberSubsystem;
    public static Winch winch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public CameraServer server;

    /**
     * Get a Friendly name for the Module. This is what the Module is referenced by. This should be unique
     * per module
     *
     * @return A unique, friendly name for the module
     */
    @Override
    public String getModuleName() {
        return "Team-5933-UBot";
    }

    /**
     * Get a Version for the Module. This should change as the Module is updated. If you Module is only being used by
     * your team, this isn't really necessary. This is here for distributed APIs and modules.
     *
     * @return The version of the module
     */
    @Override
    public String getModuleVersion() {
        return "0.1.0";
    }

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
        winch = new Winch();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        arcadeDrive = new ArcadeDrive();

        readPreferences();
    }

    private void configAutonomousCommand() {
        Preferences prefs = Preferences.getInstance();
        if (!prefs.containsKey(PreferenceConstants.AUTONOMOUS_COMMAND_KEY)) {
            return;
        }
        switch (prefs.getString(PreferenceConstants.AUTONOMOUS_COMMAND_KEY, PreferenceConstants.DEFAULT_VALUE)) {
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS1_LOWBAR:
            autonomousCommand = new Pos1LowBar();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS2_MOTE:
            autonomousCommand = new Pos2Mote();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS2_ROCKWALL:
            autonomousCommand = new Pos2RockWall();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS2_RAMPART:
            autonomousCommand = new Pos2Rampart();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS2_ROUGHTERRAIN:
            autonomousCommand = new Pos2RoughTerrain();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS3_MOTE:
            autonomousCommand = new Pos3Mote();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS3_ROCKWALL:
            autonomousCommand = new Pos3RockWall();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS3_RAMPART:
            autonomousCommand = new Pos3Rampart();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS3_ROUGHTERRAIN:
            autonomousCommand = new Pos3RoughTerrain();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS4_MOTE:
            autonomousCommand = new Pos4Mote();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS4_ROCKWALL:
            autonomousCommand = new Pos4RockWall();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS4_RAMPART:
            autonomousCommand = new Pos4Rampart();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS4_ROUGHTERRAIN:
            autonomousCommand = new Pos4RoughTerrain();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS5_MOTE:
            autonomousCommand = new Pos5Mote();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS5_ROCKWALL:
            autonomousCommand = new Pos5RockWall();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS5_RAMPART:
            autonomousCommand = new Pos5Rampart();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_POS5_ROUGHTERRAIN:
            autonomousCommand = new Pos5RoughTerrain();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_SPYBOX:
            autonomousCommand = new SpyBox();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_EC_DRIVESTRAIGHT:
            autonomousCommand = new EncoderDriveStraight();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_EC_TRURNDEGREES:
            autonomousCommand = new EncoderTurnDegrees();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_GYRO_DRIVESTRAIGHT:
            autonomousCommand = new GyroDriveStraight();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_GYRO_TURN:
            autonomousCommand = new GyroTurnDegrees();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_UC_DRIVESTRAIGHT:
            autonomousCommand = new UltrasonicDriveStraight();
            break;
        case PreferenceConstants.AUTONOMOUS_COMMAND_DRIVE_OVER_TIME:
            autonomousCommand = new DriveOverTime();
            break;
        }

        System.out.println("Autonomous Command is: " + autonomousCommand.getName());
    }

    // Read the preferences as setup by the smart dashboard preferences view.
    private void readPreferences() {
        configAutonomousCommand();
    }

    /**
     * Initializes the Starting Values on the SmartDashboard, so not to create a Null Pointer.
     */
    public void initDashboardInput() {
        SmartDashboard.putNumber("Degrees for turning", 0);
        SmartDashboard.putNumber("Inches for driving", 200);
        SmartDashboard.putNumber("Time to Drive Straight", 10);
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
        // RobotMap.enableUltrasonicTrigger(true);
        // RobotMap.helmsman.initTracking();
    	Robot.driveTrain.configForTeleopMode(); //This solves clicking in the Talons.
        Robot.driveTrain.configForAutonomous();

        if (autonomousCommand != null) { 
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        // RobotMap.helmsman.trackPosition();
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
            autonomousCommand.cancel();

        // RobotMap.enableUltrasonicTrigger(false);
        driveTrain.configForTeleopMode();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        vibrateControllers();
        turnSpindleIfNeeded();
        turnWinchIfNeeded();
        if (arcadeDrive != null) 
            arcadeDrive.start();
    }

    public void turnSpindleIfNeeded() {
        if (Robot.oi.getAButton().get() || Robot.oi.getAButton2().get()) {
            Robot.ballGrabberSubsystem.runBackward();
        } else if (Robot.oi.getBButton().get() || Robot.oi.getBButton2().get()) {
            Robot.ballGrabberSubsystem.runForward();
        } else {
            Robot.ballGrabberSubsystem.stop();
        }
    }
    public void turnWinchIfNeeded() {
        if (Robot.oi.getXButton().get() || Robot.oi.getXButton2().get()) {
            Robot.winch.down();
        } else if (Robot.oi.getYButton().get() || Robot.oi.getYButton2().get()) {
            Robot.winch.up();
        } else {
            Robot.winch.stop();
        }
    }
    /**
     * Takes the Z Axis of the RoboRIO accelerometer, and passes it to the Joystick for haptic feedback of the robot.
     */
    public void vibrateControllers() {
        double accel_z = RobotMap.helmsman.getAcceleromoterZ();
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
