package org.usfirst.frc5933.ubot;

import org.usfirst.frc5933.ubot.mapping.FieldOfPlay;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

public class Helmsman {
    
    private AnalogGyro gyro_ = RobotMap.sensorsAnalogGyro;
    private double initialGyroAngle = 0;
    private static AnalogInput forwardUltrasonic_ = RobotMap.sensorsForwardUltrasonic;
    private static final double FORWARD_V2D = 1;     // Voltage to distance (inches) scalar for forward ultrasonic
    private FieldOfPlay field_ = new FieldOfPlay();
    
    Helmsman() {
        gyro_.initGyro();
        initialGyroAngle = gyro_.getAngle();
    }
    
    public void resetGyro() {
        gyro_.reset();
    }
    
    public final double getInitialGyroAngle() {
        return initialGyroAngle;
    }
    
    public final double getGyroAngle() {
        return gyro_.getAngle();
    }
    
    public final double getForwardUltrasonicDistance() {
        return forwardUltrasonic_.getAverageVoltage() * FORWARD_V2D;
    }
    
    public void trackPosition() {
        // TODO:
    }
}
