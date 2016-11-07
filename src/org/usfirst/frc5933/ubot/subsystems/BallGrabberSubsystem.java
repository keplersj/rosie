package org.usfirst.frc5933.ubot.subsystems;

import org.usfirst.frc5933.ubot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallGrabberSubsystem extends Subsystem {

    private boolean isRunningForward = false;
    private boolean isRunningReverse = false;


    private final SpeedController spindleMotor = RobotMap.ballGrabberSubsystemSpindleMotor;

    @Override
    public void initDefaultCommand() {

    }

    public void runForward() {
        spindleMotor.set(-1.0);
    }

    public void runBackward() {
        spindleMotor.set(1.0);
    }

    public void stop() {
        spindleMotor.set(0);
    }

    public void toggleForward() {
        if (isRunningReverse)
            return;

        if (isRunningForward) {
            spindleMotor.set(0);
            isRunningForward = false;
        } else {
            spindleMotor.set(1);
            isRunningForward = true;
        }
    }

    public void toggleReverse() {
        if (isRunningForward)
            return;

        if (isRunningReverse) {
            spindleMotor.set(0);
            isRunningReverse = false;
        } else {
            spindleMotor.set(-1);
            isRunningReverse = true;
        }
    }
}

