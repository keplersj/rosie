package org.usfirst.frc5933.ubot.subsystems;

import org.usfirst.frc5933.ubot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {

    private final SpeedController winchMotor = RobotMap.winchWinchMotor;

    @Override
    protected void initDefaultCommand() {

    }

    public void up(){
        winchMotor.set(1);
    }

    public void down(){
        winchMotor.set(-1);
    }

    public void stop(){
        winchMotor.set(0);
    }
}

