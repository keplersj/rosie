package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.Preferences;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.RobotTestBase;
import org.usfirst.frc5933.ubot.commands.Pos1LowBar;
import org.usfirst.frc5933.ubot.commands.Pos2Mote;
import org.usfirst.frc5933.ubot.commands.Pos2RockWall;

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
}
