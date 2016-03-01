package org.usfirst.frc5933.ubot.mapping;

public class Shape {
    private String name_;
    private Coordinate origin_;
    
    Shape() {
        name_ = "unknown";
    }
    
    Shape(Coordinate origin) {
        name_ = "unknown";
        origin_ = origin;
    }

    Shape(String name) {
        name_ = name;
    }

    Shape(String name, Coordinate origin) {
        name_ = name;
        origin_ = origin;
    }
    
    public final String getName() {
        return name_;
    }
    
    public final Coordinate getOrigin() {
        return origin_;
    }
}
