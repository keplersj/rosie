package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos3RockWall extends CommandGroup {
    public Pos3RockWall() {
        addParallel(new LiftingArmDown(1));
        addSequential(new EncoderDriveStraight(100));
    } 
}
