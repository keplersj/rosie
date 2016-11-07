package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

public class GyroDriveStraight extends Command {
    private double inches_ = 0;
    private double speed_ = 0;
    private boolean useDumbDashboard_ = true;
    private int tickCount_ = 0;
    public final static double SOME_MULTIPLIER = 5.5;
    private final static double someDegreeOfIntoxication = 0.003;

    public GyroDriveStraight() {
        requires(Robot.driveTrain);
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

            Robot.logger.debug("Ultrasonic Front: " + RobotMap.helmsman.getForwardUltrasonicDistance() + " - " + "Ultrasonic Left: " + RobotMap.helmsman.getPortUltrasonicDistance() + " - " + "Ultrasonic Right: " + RobotMap.helmsman.getStarboardUltrasonicDistance());

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
