package org.usfirst.frc5933.ubot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.Utilities;
import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriveTrainTest {
    private static RobotDrive robotDrive;
    private static DriveTrain driveTrain;
    private CANTalon frontLeftMotor;
    private CANTalon frontRightMotor;
    private CANTalon rearLeftMotor;
    private CANTalon rearRightMotor;

    @BeforeEach
    public void startRobot() {
        Utilities.startToast();
        Robot robot = new Robot();
        robot.prestart();
        robotDrive = RobotMap.driveTrainRobotDrive;
        driveTrain = Robot.driveTrain;

        frontLeftMotor = RobotMap.driveTrainFrontLeftMotor;
        frontRightMotor = RobotMap.driveTrainFrontRightMotor;
        rearLeftMotor = RobotMap.driveTrainRearLeftMotor;
        rearRightMotor = RobotMap.driveTrainRearRightMotor;
    }

    @BeforeEach
    public void stopRobot() {
        Utilities.shutdownToast();
    }

    @Test
    public void stopTest() {
        robotDrive.tankDrive(1, 1);
        assertEquals(true, frontLeftMotor.isEnabled());
        assertEquals(true, frontRightMotor.isEnabled());
        assertEquals(true, rearLeftMotor.isEnabled());
        assertEquals(true, rearRightMotor.isEnabled());
        driveTrain.stop();
        assertEquals(false, frontLeftMotor.isEnabled());
        assertEquals(false, frontRightMotor.isEnabled());
        assertEquals(false, rearLeftMotor.isEnabled());
        assertEquals(false, rearRightMotor.isEnabled());
    }

    @Test
    public void autonomousConfigTest() {
        driveTrain.configForAutonomous();

        assertEquals(TalonControlMode.Position, frontLeftMotor.getControlMode());
        assertEquals(TalonControlMode.Position, frontRightMotor.getControlMode());
        assertEquals(TalonControlMode.Follower, rearLeftMotor.getControlMode());
        assertEquals(TalonControlMode.Follower, rearRightMotor.getControlMode());

        assertEquals(false, frontLeftMotor.getBrakeEnableDuringNeutral());
        assertEquals(false, frontRightMotor.getBrakeEnableDuringNeutral());
        assertEquals(false, rearLeftMotor.getBrakeEnableDuringNeutral());
        assertEquals(false, rearRightMotor.getBrakeEnableDuringNeutral());
    }

    @Test
    public void teleopConfigTest() {
        driveTrain.configForTeleopMode();

        assertEquals(TalonControlMode.PercentVbus, frontLeftMotor.getControlMode());
        assertEquals(TalonControlMode.PercentVbus, frontRightMotor.getControlMode());
        assertEquals(TalonControlMode.PercentVbus, rearLeftMotor.getControlMode());
        assertEquals(TalonControlMode.PercentVbus, rearRightMotor.getControlMode());
    }
}
