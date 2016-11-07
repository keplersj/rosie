package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.ubot.Robot;

public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.driveTrain.arcadeDrive(Robot.oi.getXBoxJoystick());
        // System.out.println("Ultrasonic Front: " + RobotMap.helmsman.getForwardUltrasonicDistance() + " - " + "Ultrasonic Left: " + RobotMap.helmsman.getPortUltrasonicDistance() + " - " + "Ultrasonic Right: " + RobotMap.helmsman.getStarboardUltrasonicDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
