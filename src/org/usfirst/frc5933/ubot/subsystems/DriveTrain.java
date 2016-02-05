// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.ubot.subsystems;

import org.usfirst.frc5933.ubot.RobotMap;
import org.usfirst.frc5933.ubot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon frontLeftMotor = RobotMap.driveTrainFrontLeftMotor;
    private final CANTalon rearLeftMotor = RobotMap.driveTrainRearLeftMotor;
    private final CANTalon frontRightMotor = RobotMap.driveTrainFrontRightMotor;
    private final CANTalon rearRightMotor = RobotMap.driveTrainRearRightMotor;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void tankDrive(Joystick joystick) {
        robotDrive.tankDrive(joystick, 1, joystick, 3);
    }

    public void tankDrive(Joystick leftStick, Joystick rightStick) {
    	robotDrive.tankDrive(leftStick, rightStick);
    }

    public void tankDrive(double leftStick, double rightStick) {
        robotDrive.tankDrive(leftStick, rightStick);
    }

    public void mechDrive(Joystick stick) {
    	double x = stick.getX();
    	double y = stick.getY();
    	double left = y + x;
    	double right = y - x;
    	
    	if (left > 1) {
    		left = 1;
    	}
    	if (left < -1) {
    		left = -1;
    	}
        if (right > 1) {
        	right = 1;
        }
        if (right < -1) {
        	right = -1;
        }
    	robotDrive.tankDrive(left, right);
    }

    public void arcadeDrive(Joystick stick) {
    	robotDrive.arcadeDrive(stick);
    }

    /**
     * Takes a joystick input and cubes before sending the values to the robot
     * @param stick
     */
    public void cubicArcadeDrive(Joystick stick) {
        cubicAracdeDrive(stick.getY(), stick.getX());
    }

    /**
     * Takes arcade driving values and cubes them before sending the values to the robot.
     *
     * @param move How much the bot is wanted to move.
     * @param rotate How much the bot is wanted to rotate.
     */
    public void cubicAracdeDrive(double move, double rotate) {
        double newMove = Math.pow(move, 3);
        double newRotate = Math.pow(rotate, 3);
        robotDrive.arcadeDrive(newMove, newRotate);
    }

    public void driveStraight(double speed) {
    	robotDrive.tankDrive(speed, speed);
    }
}

