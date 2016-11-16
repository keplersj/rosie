package org.usfirst.frc5933;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.usfirst.frc5933.Utilities.initToast;
import static org.usfirst.frc5933.Utilities.shutdownToast;
import static org.usfirst.frc5933.Utilities.startToast;

public class RobotTestBase {
    @BeforeAll
    public static void startupToast() {
        startToast();
    }

    @BeforeEach
    public void initializeToast() {
        initToast();
    }

    @AfterEach
    public void cleanupToast() {
        shutdownToast();
    }
}
