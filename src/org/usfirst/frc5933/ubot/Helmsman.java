package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Helmsman {

    private AnalogGyro gyro_ = RobotMap.sensorsAnalogGyro;

    private BuiltInAccelerometer accel_ = new BuiltInAccelerometer();

    private static final double FORWARD_V2D = 85.7;     // Voltage to distance (inches) scalar for forward ultrasonic
    private static final double PORT_V2D = 85.7;     // Voltage to distance (inches) scalar for port ultrasonic
    private static final double STARBOARD_V2D = 85.7;     // Voltage to distance (inches) scalar for starboard ultrasonic

    private static AnalogInput forwardUltrasonic_ = RobotMap.sensorsForwardUltrasonic; //bow
    private static AnalogInput portUltrasonic_ = RobotMap.sensorsPortUltrasonic; //left
    private static AnalogInput starboardUltrasonic_ = RobotMap.sensorsStarboardUltrasonic; //right

    Helmsman() {
        gyro_.initGyro();
    }

    public void resetGyro() {
        gyro_.reset();
    }

    public final double getCurrentGyroAngle() {
        return gyro_.getAngle();
    }

    public final double getForwardUltrasonicDistance() {
        return forwardUltrasonic_.getAverageVoltage() * FORWARD_V2D;
    }

    public final double getPortUltrasonicDistance() {
        return portUltrasonic_.getAverageVoltage() * PORT_V2D;
    }

    public final double getStarboardUltrasonicDistance() {
        return starboardUltrasonic_.getAverageVoltage() * STARBOARD_V2D;
    }

    final double getAcceleromoterZ() {
        return accel_.getZ();
    }

}
