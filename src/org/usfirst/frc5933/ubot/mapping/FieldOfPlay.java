package org.usfirst.frc5933.ubot.mapping;

import java.util.ArrayList;

public class FieldOfPlay extends Rectangle {
    private static final String ARENA_NAME = "Stronghold";
    private static final Coordinate ARENA_ORIGIN = new Coordinate(0, 0, 0);
    private static final double ARENA_WIDTH_INCHES = (26 * 12) + 7;
    private static final double ARENA_LENGTH_INCHES = (54 * 12) + 1;

    private ArrayList landmarks_ = new ArrayList();
    
    public FieldOfPlay() {
        super(ARENA_NAME, ARENA_ORIGIN, ARENA_WIDTH_INCHES, ARENA_LENGTH_INCHES);
        landmarks_.add(new Landmark("RedTower", new Coordinate(6, 7, 8))); // FIXME
    }
}
