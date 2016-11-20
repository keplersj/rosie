package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.Preferences;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.RobotTestBase;
import org.usfirst.frc5933.ubot.commands.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PreferenceConstantsTest extends RobotTestBase {
    private Preferences prefs;
    private Robot robot;

    @BeforeEach
    public void setup() {
        robot = new Robot();
        robot.prestart();
        prefs = Preferences.getInstance();
    }

    @Test
    public void noCommandStringTest() {
        prefs.remove("AutonomousCommand");
        robot.start();
        assertNull(robot.autonomousCommand);
    }

    @Test
    public void pos1LowBarCommandTest() {
        prefs.putString("AutonomousCommand", "Pos1LowBar");
        robot.start();
        assertEquals(Pos1LowBar.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2Mote");
        robot.start();
        assertEquals(Pos2Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2RockWall");
        robot.start();
        assertEquals(Pos2RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RampartCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2Rampart");
        robot.start();
        assertEquals(Pos2Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RoughTerrainCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2RoughTerrain");
        robot.start();
        assertEquals(Pos2RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos3Mote");
        robot.start();
        assertEquals(Pos3Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos3RockWall");
        robot.start();
        assertEquals(Pos3RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RampartCommandTest() {
        prefs.putString("AutonomousCommand", "Pos3Rampart");
        robot.start();
        assertEquals(Pos3Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RoughTerrainCommandTest() {
        prefs.putString("AutonomousCommand", "Pos3RoughTerrain");
        robot.start();
        assertEquals(Pos3RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos4Mote");
        robot.start();
        assertEquals(Pos4Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos4RockWall");
        robot.start();
        assertEquals(Pos4RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RampartCommandTest() {
        prefs.putString("AutonomousCommand", "Pos4Rampart");
        robot.start();
        assertEquals(Pos4Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RoughTerrainCommandTest() {
        prefs.putString("AutonomousCommand", "Pos4RoughTerrain");
        robot.start();
        assertEquals(Pos4RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos5Mote");
        robot.start();
        assertEquals(Pos5Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos5RockWall");
        robot.start();
        assertEquals(Pos5RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RampartCommandTest() {
        prefs.putString("AutonomousCommand", "Pos5Rampart");
        robot.start();
        assertEquals(Pos5Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RoughTerrainCommandTest() {
        prefs.putString("AutonomousCommand", "Pos5RoughTerrain");
        robot.start();
        assertEquals(Pos5RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void spyBoxCommandTest() {
        prefs.putString("AutonomousCommand", "SpyBox");
        robot.start();
        assertEquals(SpyBox.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void encoderDriveStraightCommandTest() {
        prefs.putString("AutonomousCommand", "EncoderDriveStraight");
        robot.start();
        assertEquals(EncoderDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void encoderTurnDegreesCommandTest() {
        prefs.putString("AutonomousCommand", "EncoderTurnDegrees");
        robot.start();
        assertEquals(EncoderTurnDegrees.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void gyroDriveStraightCommandTest() {
        prefs.putString("AutonomousCommand", "GyroDriveStraight");
        robot.start();
        assertEquals(GyroDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void gyroTurnDegreesCommandTest() {
        prefs.putString("AutonomousCommand", "GyroTurnDegrees");
        robot.start();
        assertEquals(GyroTurnDegrees.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void ultrasonicDriveStraightCommandTest() {
        prefs.putString("AutonomousCommand", "UltrasonicDriveStraight");
        robot.start();
        assertEquals(UltrasonicDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void driveOverTimeCommandTest() {
        prefs.putString("AutonomousCommand", "DriveOverTime");
        robot.start();
        assertEquals(DriveOverTime.class, robot.autonomousCommand.getClass());
    }
}
