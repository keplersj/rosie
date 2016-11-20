package org.usfirst.frc5933.ubot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.Utilities;
import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DriveTrainTest {
    private static RobotDrive robotDrive;
    private static DriveTrain driveTrain;

    @BeforeAll
    public static void startRobot() {
        Utilities.startToast();
        Robot robot = new Robot();
        robot.prestart();
        robotDrive = RobotMap.driveTrainRobotDrive;
        driveTrain = Robot.driveTrain;
    }

    @AfterAll
    public static void stopRobot() {
        Utilities.shutdownToast();
    }

    @Test
    public void stopTest() {
        robotDrive.tankDrive(1, 1);
        assertEquals(true, RobotMap.driveTrainFrontLeftMotor.isEnabled());
        assertEquals(true, RobotMap.driveTrainFrontRightMotor.isEnabled());
        assertEquals(true, RobotMap.driveTrainRearLeftMotor.isEnabled());
        assertEquals(true, RobotMap.driveTrainRearRightMotor.isEnabled());
        driveTrain.stop();
        assertEquals(false, RobotMap.driveTrainFrontLeftMotor.isEnabled());
        assertEquals(false, RobotMap.driveTrainFrontRightMotor.isEnabled());
        assertEquals(false, RobotMap.driveTrainRearLeftMotor.isEnabled());
        assertEquals(false, RobotMap.driveTrainRearRightMotor.isEnabled());
    }
}
