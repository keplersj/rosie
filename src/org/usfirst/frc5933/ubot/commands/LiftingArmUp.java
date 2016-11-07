package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.ubot.Robot;

public class LiftingArmUp extends Command {
	private double secondsToStayOn_ = 0;
    private double startTimestamp_ = 0;

    LiftingArmUp(double seconds) {
        secondsToStayOn_ = seconds;
        startTimestamp_ = 0;
    }

    public LiftingArmUp() {
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	startTimestamp_ = System.currentTimeMillis();
    	Robot.arm.up();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if (secondsToStayOn_ == 0) {
            return Robot.arm.isStopped();
        } else {
            double now = System.currentTimeMillis();
            double when = startTimestamp_ + (secondsToStayOn_ * 1000); 
            if (now > when) {
                Robot.arm.stop();
                return true;
            } else {
                return false;
            }
        }
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
