package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.ubot.Robot;

class ToggleReverseSpindle extends Command {
    private double secondsToStayOn_ = 0;
    private double startTimestamp_ = 0;

    ToggleReverseSpindle(double seconds) {
        secondsToStayOn_ = seconds;
        startTimestamp_ = 0;
    }

    ToggleReverseSpindle() {
        requires(Robot.ballGrabberSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        startTimestamp_ = System.currentTimeMillis();
        Robot.ballGrabberSubsystem.toggleReverse();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (secondsToStayOn_ == 0) {
            return true;
        } else {
            double now = System.currentTimeMillis();
            double when = startTimestamp_ + (secondsToStayOn_ * 1000); 
            if (now > when) {
                Robot.ballGrabberSubsystem.toggleReverse();
                return true;
            } else {
                return false;
            }
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
