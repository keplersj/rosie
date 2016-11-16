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
        assertEquals(robot.autonomousCommand.getClass(), Pos1LowBar.class);
    }

    @Test
    public void pos2MoteCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2Mote");
        robot.configAutonomousCommand();
        assertEquals(robot.autonomousCommand.getClass(), Pos2Mote.class);
    }

    @Test
    public void pos2RockwallCommandTest() {
        prefs.putString("AutonomousCommand", "Pos2RockWall");
        robot.configAutonomousCommand();
        assertEquals(robot.autonomousCommand.getClass(), Pos2RockWall.class);
    }

    @Test
    public void pos2RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos2Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos2Rampart.class);
    }

    @Test
    public void pos2RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos2RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos2RoughTerrain.class);
    }

    @Test
    public void pos3MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3Mote");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos3Mote.class);
    }

    @Test
    public void pos3RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos3RockWall.class);
    }

    @Test
    public void pos3RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos3Rampart.class);
    }

    @Test
    public void pos3RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos3RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos3RoughTerrain.class);
    }

    @Test
    public void pos4MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4Mote");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos4Mote.class);
    }

    @Test
    public void pos4RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos4RockWall.class);
    }

    @Test
    public void pos4RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos4Rampart.class);
    }

    @Test
    public void pos4RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos4RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos4RoughTerrain.class);
    }

    @Test
    public void pos5MoteCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5Mote");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos5Mote.class);
    }

    @Test
    public void pos5RockwallCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5RockWall");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos5RockWall.class);
    }

    @Test
    public void pos5RampartCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5Rampart");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos5Rampart.class);
    }

    @Test
    public void pos5RoughTerrainCommandTest() {
        this.prefs.putString("AutonomousCommand", "Pos5RoughTerrain");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), Pos5RoughTerrain.class);
    }

    @Test
    public void spyBoxCommandTest() {
        this.prefs.putString("AutonomousCommand", "SpyBox");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), SpyBox.class);
    }

    @Test
    public void encoderDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "EncoderDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), EncoderDriveStraight.class);
    }

    @Test
    public void encoderTurnDegreesCommandTest() {
        this.prefs.putString("AutonomousCommand", "EncoderTurnDegrees");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), EncoderTurnDegrees.class);
    }

    @Test
    public void gyroDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "GyroDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), GyroDriveStraight.class);
    }

    @Test
    public void gyroTurnDegreesCommandTest() {
        this.prefs.putString("AutonomousCommand", "GyroTurnDegrees");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), GyroTurnDegrees.class);
    }

    @Test
    public void ultrasonicDriveStraightCommandTest() {
        this.prefs.putString("AutonomousCommand", "UltrasonicDriveStraight");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), UltrasonicDriveStraight.class);
    }

    @Test
    public void driveOverTimeCommandTest() {
        this.prefs.putString("AutonomousCommand", "DriveOverTime");
        this.robot.configAutonomousCommand();
        assertEquals(this.robot.autonomousCommand.getClass(), DriveOverTime.class);
    }
}
