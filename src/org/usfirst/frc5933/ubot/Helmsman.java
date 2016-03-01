package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

public class Helmsman {
    private AnalogGyro gyro_ = RobotMap.sensorsAnalogGyro;
    private double initialGyroAngle = 0;

    public static AnalogInput forwardUltrasonic_ = RobotMap.sensorsForwardUltrasonic;
    
    // Voltage to distance (inches) scalar for forward ultrasonic
    public static final double FORWARD_V2D = 1;
    
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
}
