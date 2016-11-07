package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import jaci.openrio.toast.lib.registry.Registrar;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static CANTalon driveTrainFrontLeftMotor;
    public static CANTalon driveTrainRearLeftMotor;
    public static CANTalon driveTrainFrontRightMotor;
    public static CANTalon driveTrainRearRightMotor;
    public static RobotDrive driveTrainRobotDrive;
    public static PowerDistributionPanel powerPowerDistributionPanel;
    public static SpeedController armWindowMotor;
    public static AnalogGyro sensorsAnalogGyro;
    public static AnalogInput sensorsForwardUltrasonic;
    public static AnalogInput sensorsPortUltrasonic;
    public static AnalogInput sensorsStarboardUltrasonic;
    public static DigitalOutput sensorsUltrasonicTrigger;
    public static SpeedController ballGrabberSubsystemSpindleMotor;
    public static SpeedController winchWinchMotor;

    public static Helmsman helmsman; //call sensors (analog inputs) through this

    static void init() {
        driveTrainFrontLeftMotor = Registrar.canTalon(12);
        LiveWindow.addActuator("DriveTrain", "FrontLeftMotor", driveTrainFrontLeftMotor);

        driveTrainRearLeftMotor = Registrar.canTalon(11);
        LiveWindow.addActuator("DriveTrain", "RearLeftMotor", driveTrainRearLeftMotor);

        driveTrainFrontRightMotor = Registrar.canTalon(10);
        LiveWindow.addActuator("DriveTrain", "FrontRightMotor", driveTrainFrontRightMotor);

        driveTrainRearRightMotor = Registrar.canTalon(13);
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

        armWindowMotor = Registrar.jaguar(7);
        LiveWindow.addActuator("Arm", "WindowMotor", (Jaguar) armWindowMotor);

        sensorsAnalogGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Sensors", "AnalogGyro", sensorsAnalogGyro);
        sensorsAnalogGyro.setSensitivity(0.007);

        sensorsForwardUltrasonic = new AnalogInput(1);
        LiveWindow.addSensor("Sensors", "ForwardUltrasonic", sensorsForwardUltrasonic);

        sensorsPortUltrasonic = new AnalogInput(2);
        LiveWindow.addSensor("Sensors", "PortUltrasonic", sensorsPortUltrasonic);

        sensorsStarboardUltrasonic = new AnalogInput(3);
        LiveWindow.addSensor("Sensors", "StarboardUltrasonic", sensorsStarboardUltrasonic);

        sensorsUltrasonicTrigger = new DigitalOutput(1);
        LiveWindow.addActuator("Sensors", "UltrasonicTrigger", sensorsUltrasonicTrigger);

        ballGrabberSubsystemSpindleMotor = new Jaguar(0);
        LiveWindow.addActuator("BallGrabberSubsystem", "SpindleMotor", (Jaguar) ballGrabberSubsystemSpindleMotor);

        winchWinchMotor = new Jaguar(2);
        LiveWindow.addActuator("Winch", "WinchMotor", (Jaguar) winchWinchMotor);

        helmsman = new Helmsman();
    }

}
