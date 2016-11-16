package org.usfirst.frc5933.ubot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.usfirst.frc5933.RobotTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest extends RobotTestBase {

    private static Robot robot;

    @BeforeAll
    public static void beforeAll() {
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
