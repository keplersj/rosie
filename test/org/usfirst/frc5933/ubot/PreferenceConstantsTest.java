package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.Preferences;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.usfirst.frc5933.ubot.commands.Pos1LowBar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.usfirst.frc5933.Utilities.setupToast;

public class PreferenceConstantsTest {
    Preferences prefs;
    static Robot robot;

    @BeforeClass
    public static void setupClass() {
        setupToast();
        robot = new Robot();
        robot.prestart();
    }

    @Before
    public void setup() {
        prefs = Preferences.getInstance();
    }

    @Test
    public void noCommandStringTest() {
        prefs.remove("AutonomousCommand");
        robot.configAutonomousCommand();
        assertNull(robot.autonomousCommand);
    }

    @Test
    public void pos1CommandTest() {
        prefs.putString("AutonomousCommand", "Pos1LowBar");
        robot.configAutonomousCommand();
        assertEquals(robot.autonomousCommand.getClass(), Pos1LowBar.class);
    }
}
