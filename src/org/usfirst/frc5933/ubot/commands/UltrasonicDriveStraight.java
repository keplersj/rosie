package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5933.ubot.PreferenceConstants;
import org.usfirst.frc5933.ubot.Robot;
import org.usfirst.frc5933.ubot.RobotMap;

public class UltrasonicDriveStraight extends Command {
    private double inches_ = 0;
    private double speed_ = 0;
    private int tickCount_ = 5;
    private final static double someDegreeOfIntoxication = 0.001;
    private double lastWallDistance = 12;
    private boolean useDumbDashboard_ = true;

    public UltrasonicDriveStraight() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        if (useDumbDashboard_) {
            speed_ = .5;
            inches_ = SmartDashboard.getNumber("Inches for driving");
        }
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        int absoluteCount_ = 0;
        while (tickCount_ > 0) {

            double wallDistance = RobotMap.helmsman.getPortUltrasonicDistance();

            double curve = (wallDistance - lastWallDistance) * someDegreeOfIntoxication; //
            Robot.driveTrain.driveStraight(-speed_, -curve); //DO NOT change this

            Robot.logger.debug("Ultrasonic Front: " + RobotMap.helmsman.getForwardUltrasonicDistance() + " - " + "Ultrasonic Left: " + RobotMap.helmsman.getPortUltrasonicDistance() + " - " + "Ultrasonic Right: " + RobotMap.helmsman.getStarboardUltrasonicDistance());

            if (RobotMap.helmsman.getForwardUltrasonicDistance() < inches_){ //drive until x' away from wall
                ++absoluteCount_;
                if (absoluteCount_ > 4){
                    tickCount_ = 0;
                    absoluteCount_ = 0;
                }

            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return tickCount_ == 0;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
