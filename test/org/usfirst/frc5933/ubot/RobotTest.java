package org.usfirst.frc5933.ubot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    private static Robot robot;

    @Before
    public void beforeAll() {
        robot = new Robot();
    }

    // Yes I know this is pointless, but I want that code coverage!
    @Test
    public void testModuleName() {
        assertEquals("Rosie", robot.getModuleName());
    }

    // Yes I know this is pointless, but I want that code coverage!
    @Test
    public void testModuleVersion() {
        assertEquals("1.0.0", robot.getModuleVersion());
    }

}
