package org.usfirst.frc5933.ubot.mapping;

public class Rectangle extends Shape {
    private double width_ = 0;
    private double length_ = 0;
    
    public Rectangle() {
        super();
    }

    public Rectangle(String name) {
        super(name);
    }
    
    public Rectangle(String name, Coordinate origin) {
        super(name, origin);
    }

    public Rectangle(Coordinate origin) {
        super(origin);
    }
    
    public Rectangle(String name, Coordinate origin, double width, double length) {
        super(name, origin);
        width_ = width;
        length_ = length;
    }
    
    public final double getWidth() {
        return width_;
    }
    
    public final double getLength() {
        return width_;
    }
}
