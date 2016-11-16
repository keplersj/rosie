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
        robot.configAutonomousCommand();
        assertNull(robot.autonomousCommand);
    }

    @Test
    public void pos1LowBarCommandTest() {
        prefs.putString("AutonomousCommand", "Pos1LowBar");
        robot.configAutonomousCommand();
        assertEquals(Pos1LowBar.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2Mote");
        robot.configAutonomousCommand();
        assertEquals(Pos2Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2RockWall");
        robot.configAutonomousCommand();
        assertEquals(Pos2RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos2Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(Pos2Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos2RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos2RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(Pos2RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3Mote");
        this.robot.configAutonomousCommand();
        assertEquals(Pos3Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(Pos3RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(Pos3Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos3RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(Pos3RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4Mote");
        this.robot.configAutonomousCommand();
        assertEquals(Pos4Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(Pos4RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(Pos4Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos4RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(Pos4RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5Mote");
        this.robot.configAutonomousCommand();
        assertEquals(Pos5Mote.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(Pos5RockWall.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(Pos5Rampart.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void pos5RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(Pos5RoughTerrain.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void spyBoxCommandTest() {
        this.prefs.putString("AutonomousCommand", "SpyBox");
        this.robot.configAutonomousCommand();
        assertEquals(SpyBox.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void encoderDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "EncoderDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(EncoderDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void encoderTurnDegreesCommandTest() {
        this.prefs.putString("AutonomousCommand", "EncoderTurnDegrees");
        this.robot.configAutonomousCommand();
        assertEquals(EncoderTurnDegrees.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void gyroDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "GyroDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(GyroDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void gyroTurnDegreesCommandTest() {
        this.prefs.putString("AutonomousCommand", "GyroTurnDegrees");
        this.robot.configAutonomousCommand();
        assertEquals(GyroTurnDegrees.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void ultrasonicDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "UltrasonicDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(UltrasonicDriveStraight.class, robot.autonomousCommand.getClass());
    }

    @Test
    public void driveOverTimeCommandTest() {
        this.prefs.putString("AutonomousCommand", "DriveOverTime");
        this.robot.configAutonomousCommand();
        assertEquals(DriveOverTime.class, robot.autonomousCommand.getClass());
    }
}
