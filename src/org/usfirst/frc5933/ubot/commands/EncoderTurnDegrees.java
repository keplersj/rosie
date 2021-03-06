// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.PreferenceConstants;
import org.usfirst.frc5933.ubot.Robot;

/**
 *
 */
public class EncoderTurnDegrees extends Command {
    private double degrees_ = 0;
    private boolean useDumbDashboard_ = true;
    private double degreesToRotations_ = 0.027;

    public EncoderTurnDegrees(double degrees) {
        degrees_ = degrees;
        useDumbDashboard_ = false;
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public EncoderTurnDegrees() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.configForTeleopMode(); //This solves clicking in the Talons.
        Robot.driveTrain.configForAutonomous();

        if (useDumbDashboard_) {
            degrees_ = SmartDashboard.getNumber("Degrees for turning");
        }
        degreesToRotations_ = Preferences.getInstance().getDouble(PreferenceConstants.DEGREES_TO_ROTATIONS, degreesToRotations_);

        double leftRotations = degreesToRotations_ * -degrees_;
        double rightRotations = degreesToRotations_ * degrees_;

        Robot.driveTrain.startPositionMovement(leftRotations, rightRotations);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.executePositionMove();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.hasFinishedPositionMovement();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.endPositionMovement();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
