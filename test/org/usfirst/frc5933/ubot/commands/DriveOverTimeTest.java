package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.CANTalon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.Utilities;
import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriveOverTimeTest {

    DriveOverTime command;
    private CANTalon frontLeftMotor;
    private CANTalon frontRightMotor;
    private CANTalon rearLeftMotor;
    private CANTalon rearRightMotor;

    @BeforeEach
    public void start() {
        Utilities.startToast();
        Robot robot = new Robot();
        robot.prestart();
        command = new DriveOverTime(5);

        frontLeftMotor = RobotMap.driveTrainFrontLeftMotor;
        frontRightMotor = RobotMap.driveTrainFrontRightMotor;
        rearLeftMotor = RobotMap.driveTrainRearLeftMotor;
        rearRightMotor = RobotMap.driveTrainRearRightMotor;
    }

    @AfterEach
    public void shutdown() {
        Utilities.shutdownToast();
    }

    @Test
    public void driveTest() {
        assertEquals(0, frontLeftMotor.get());
        assertEquals(0, frontRightMotor.get());
        assertEquals(0, rearLeftMotor.get());
        assertEquals(0, rearRightMotor.get());

        command.initialize();
        while (!command.isFinished()) {
            command.execute();
            assertEquals(1, frontLeftMotor.get());
            assertEquals(-1, frontRightMotor.get());
            assertEquals(1, rearLeftMotor.get());
            assertEquals(-1, rearRightMotor.get());
            assertEquals(true, frontLeftMotor.isEnabled());
            assertEquals(true, frontRightMotor.isEnabled());
            assertEquals(true, rearLeftMotor.isEnabled());
            assertEquals(true, rearRightMotor.isEnabled());
        }
        assertEquals(true, command.isFinished());
        command.end();
        assertEquals(false, frontLeftMotor.isEnabled());
        assertEquals(false, frontRightMotor.isEnabled());
        assertEquals(false, rearLeftMotor.isEnabled());
        assertEquals(false, rearRightMotor.isEnabled());
    }
}
