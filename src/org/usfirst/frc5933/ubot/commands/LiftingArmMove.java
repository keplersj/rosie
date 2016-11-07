package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.ubot.Robot;

public class LiftingArmMove extends Command {
    public LiftingArmMove() {
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.arm.joystickMove();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.arm.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
