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
import org.usfirst.frc5933.ubot.RobotMap;

/**
 *
 */
public class GyroDriveStraight extends Command {
    private double inches_ = 0;
    private double speed_ = 0;
    private boolean useDumbDashboard_ = true;
    private int tickCount_ = 0;
    public final static double SOME_MULTIPLIER = 5.5;
    public final static double someDegreeOfIntoxication = 0.003;
    private boolean debug_ = false;

    public GyroDriveStraight(double speed, double inches) {
        speed_ = speed;
        inches_ = inches;
        useDumbDashboard_ = false;

        // use the preferences to determine if we should debug this subsystem
        if (Preferences.getInstance().containsKey(PreferenceConstants.DEBUG_SUBSYSTEM_GYRO_KEY)) {
            debug_ = Preferences.getInstance().getBoolean(PreferenceConstants.DEBUG_SUBSYSTEM_GYRO_KEY, false);
        }
    }


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public GyroDriveStraight() {

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
            speed_ = .8;
            inches_ = SmartDashboard.getNumber("Inches for driving");
        }

//        Robot.driveTrain.enableBrakeMode(true);
        RobotMap.helmsman.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        int absoluteCount_ = 0;
        while (tickCount_ > 0) {

            double angle = RobotMap.helmsman.getCurrentGyroAngle();
            double curve = angle * someDegreeOfIntoxication; //worked 2/23/16 as 0.003 "someDegreeOfIntoxication"
            Robot.driveTrain.driveStraight(-speed_, -curve); //DO NOT change this

            if (debug_)
                System.out.println("Ultrasonic Front: " + RobotMap.helmsman.getForwardUltrasonicDistance() + " - " + "Ultrasonic Left: " + RobotMap.helmsman.getPortUltrasonicDistance() + " - " + "Ultrasonic Right: " + RobotMap.helmsman.getStarboardUltrasonicDistance());

            if (RobotMap.helmsman.getForwardUltrasonicDistance() < inches_){ //drive until x' away from wall
                ++absoluteCount_;
                if (absoluteCount_ > 15){
                    tickCount_ = 0;
                }
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return tickCount_ == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
//        Robot.driveTrain.enableBrakeMode(false);
        Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
