package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

public class GyroTurnDegrees extends Command {

    private double degrees_ = 0;
    private boolean useDumbDashboard_ = true;
    private boolean debug_ = false;
    private boolean finished = false;

    private static final int TURN_MAX_TRIES = 1000;
    private int tries = TURN_MAX_TRIES;

    private double desired;
    private double startingAngle;
    private double now;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public GyroTurnDegrees() {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (useDumbDashboard_) {
            degrees_ = SmartDashboard.getNumber("Degrees for turning");
        }
//        Robot.driveTrain.enableBrakeMode(true);
        Robot.driveTrain.configForTeleopMode();

        RobotMap.helmsman.resetGyro();
        startingAngle = RobotMap.helmsman.getCurrentGyroAngle();
        now = startingAngle;
        desired = degrees_;

        // This call blocks execution, (not really ideal, but hey lets go with it for now)
        // so the operation will return finish during init, so there is no need for us
        // to call anything in execute. This allows us to return true for the isFinished
        // method since we will have finished the turn before isFinished has been called.
        //Robot.driveTrain.gyroTurnDegrees(-degrees_);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = 0.5;
        if (now < desired - 50) {
            speed = 0.8;
        }
        else if ( now >= desired-5) {
            if (debug_)
                System.out.println("It should be stopping!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            finished = true;
            Robot.driveTrain.stop();
        }

        if (desired > startingAngle) {
            Robot.driveTrain.set(-speed, 0);
        } else {
            Robot.driveTrain.set(0, -speed);
        }
        now = RobotMap.helmsman.getCurrentGyroAngle();
        if (debug_)
            System.out.println("Angle: " + now);
        --tries;
        if (tries == 0) {
            finished = true;
            end();
            if (debug_)
                System.err.println("Failed to turn specified degrees.");
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
//        Robot.driveTrain.enableBrakeMode(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
