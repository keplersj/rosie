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

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc5933.ubot.CameraFeeds;
import org.usfirst.frc5933.ubot.RobotMap;
import org.usfirst.frc5933.ubot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5933.ubot.Robot;

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

    private boolean isReversed = false;
    public static final double RIGHT_DRIVE_MULTIPLIER = 1.0;
    public static final double LEFT_DRIVE_MULTIPLIER = 1.08;
    
    public static final double TURBO_FAST_MULTIPLIER = 1.0;
    public static final double TURBO_SLOW_MULTIPLIER = 0.5;
    private double turboMultiplier = TURBO_FAST_MULTIPLIER;

	private static CameraFeeds feeds = new CameraFeeds();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void arcadeDrive(Joystick stick) {
    	double y = stick.getY();
    	double x = stick.getX();
    	if (isReversed) {
    		y *= -1;
    		x *= -1;
    	}

    	y *= turboMultiplier;
    	x *= turboMultiplier;
    	
    	// TODO: if we want the arcade to drive straight, we will need
    	// to scale x by some factor.
    	// I think the best way to do this is to temporarily set x to zero,
    	// drive the robot using only the y value and slowly change x by some
    	// multiplier value until it goes straight. Then let the value of
    	// x remain like it should and see how well it works. Make sure to handle
    	// the cases where x is: 0, -, +.
    	robotDrive.arcadeDrive(y, x);
    }

    public void driveStraight(double speed) {
    	double left = speed * LEFT_DRIVE_MULTIPLIER;
    	double right = speed * RIGHT_DRIVE_MULTIPLIER;
    	
    	if (isReversed) {
    		left *= -1;
    		right *= -1;
    	}
    	
    	left *= turboMultiplier;
    	right *= turboMultiplier;
    	
    	robotDrive.tankDrive(left, right);
    }
    
    public void toggleTurbo() {
    	if (turboMultiplier == TURBO_FAST_MULTIPLIER) {
    		turboMultiplier = TURBO_SLOW_MULTIPLIER;
    	} else {
    		turboMultiplier = TURBO_FAST_MULTIPLIER;
    	}
    }
    
    public void reverseControls() {
    	robotDrive.tankDrive(0, 0);
    	Timer.delay(1.0);
    	isReversed = !isReversed;
    }
    
    public void turnDegrees(double speed, double degrees) {
		AnalogGyro gyro = RobotMap.sensorsAnalogGyro;
		gyro.reset();
		double current = gyro.getAngle();
		System.out.println("Hello from Rotation.");
		System.out.println("Starting: " + current);
		while (current < 90) {
			current = gyro.getAngle();
			robotDrive.drive(speed, -1);
			System.out.println("Current Angle: " + current);
		}
		robotDrive.stopMotor();
    }

    /**
        aligns the robot to 0 degrees, which would be the starting orientation
        @param speed 
        inputs the speed at which to turn
    **/
    public void alignZeroDegrees(double speed){

        double degreesToTurn = gyro.getAngle() %  360;
        int amountOfRotations = (int) gyro.getAngle / 360;

        if(degreesToTurn < 180){
            while(amountOfRotations == (int) (gyro.getAngle / 360)){
                    RobotDrive.drive(speed, 1);
                    degreesToTurn = gyro.getAngle() %  360;
            }
        } else if(degreesToTurn > 180){
            while(amountOfRotations == (int) (gyro.getAngle() / 360)){
                while(degreesToTurn < 0){
                    RobotDrive.drive(speed, -1);
                    degreesToTurn = gyro.getAngle() %  360;
                }
            }
        }
    }

    /**
        aligns the robot to 180 degrees, which is facing the opposite of starting position
        @param speed
        inputs the speed at which to turn
    **/
    public void align180Degrees(double speed){
        double degreesToTurn = gyro.getAngle() % 360;

        if(degreesToTurn < 180){

            while(degreesToTurn < 180){
                RobotDrive.drive(speed, -1);
                degreesToTurn = gyro.getAngle() %  360;
            }

        } else if(degreesToTurn > 180){

            while(degreesToTurn > 180){
                RobotDrive.drive(speed, 1);
                degreesToTurn = gyro.getAngle() %  360;
            }

        }
    }


    
}
