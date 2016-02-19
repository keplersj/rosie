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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainFrontLeftMotor;
    public static CANTalon driveTrainRearLeftMotor;
    public static CANTalon driveTrainFrontRightMotor;
    public static CANTalon driveTrainRearRightMotor;
    public static RobotDrive driveTrainRobotDrive;
    public static PowerDistributionPanel powerPowerDistributionPanel;
    public static SpeedController armWindowMotor;
    public static AnalogGyro sensorsAnalogGyro;
    public static SpeedController ballGrabberSubsystemSpindleMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainFrontLeftMotor = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "FrontLeftMotor", driveTrainFrontLeftMotor);
        
        driveTrainRearLeftMotor = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "RearLeftMotor", driveTrainRearLeftMotor);
        
        driveTrainFrontRightMotor = new CANTalon(10);
        LiveWindow.addActuator("DriveTrain", "FrontRightMotor", driveTrainFrontRightMotor);
        
        driveTrainRearRightMotor = new CANTalon(13);
        LiveWindow.addActuator("DriveTrain", "RearRightMotor", driveTrainRearRightMotor);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainFrontLeftMotor, driveTrainRearLeftMotor,
              driveTrainFrontRightMotor, driveTrainRearRightMotor);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        powerPowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Power", "PowerDistributionPanel", powerPowerDistributionPanel);
        
        armWindowMotor = new Jaguar(7);
        LiveWindow.addActuator("Arm", "WindowMotor", (Jaguar) armWindowMotor);
        
        sensorsAnalogGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Sensors", "AnalogGyro", sensorsAnalogGyro);
        sensorsAnalogGyro.setSensitivity(0.007);
        ballGrabberSubsystemSpindleMotor = new Jaguar(0);
        LiveWindow.addActuator("BallGrabberSubsystem", "SpindleMotor", (Jaguar) ballGrabberSubsystemSpindleMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
