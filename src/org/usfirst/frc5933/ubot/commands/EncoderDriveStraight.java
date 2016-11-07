package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.PreferenceConstants;
import org.usfirst.frc5933.ubot.Robot;

public class EncoderDriveStraight extends Command {
    private double inches_ = 0;
    private boolean useDumbDashboard_ = true;
    private double inchesToRotations_ = 0.0908;


    public EncoderDriveStraight(double inches) {
        inches_ = inches;
        useDumbDashboard_ = false;
    }

    public EncoderDriveStraight() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (useDumbDashboard_) {
            inches_ = SmartDashboard.getNumber("Inches for driving");
        }
        inchesToRotations_ = Preferences.getInstance().getDouble(PreferenceConstants.INCHES_TO_ROTATIONS, inchesToRotations_);
        Robot.driveTrain.startPositionMovement(inchesToRotations_ * inches_, inchesToRotations_ * inches_);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.driveTrain.executePositionMove();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.driveTrain.hasFinishedPositionMovement();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.endPositionMovement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
