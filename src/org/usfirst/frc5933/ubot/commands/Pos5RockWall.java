package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos5RockWall extends CommandGroup {
    public Pos5RockWall() {
        addParallel(new LiftingArmDown(1));
        addSequential(new EncoderDriveStraight(100));
    } 
}
