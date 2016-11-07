package org.usfirst.frc5933.ubot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

public class Arm extends Subsystem {

    private final SpeedController windowMotor = RobotMap.armWindowMotor;

    @Override
    public void initDefaultCommand() {

    }

    public void up() {
        windowMotor.set(1);
    }

    public void joystickMove() {
        double value = Robot.oi.getXBoxJoystick().getRawAxis(5);
        if (Robot.oi.rightJoystickButton2.get()) {
            value = Robot.oi.getXBoxJoystick2().getRawAxis(5);
        }
        windowMotor.set(value);
        Timer.delay(0.01);
    }

    public void down() {
        windowMotor.set(-1);
    }

    public void stop() {
        windowMotor.set(0);
    }

    public boolean isStopped() {
        return false;
    }
}

