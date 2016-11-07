package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos3RoughTerrain extends CommandGroup {
    public Pos3RoughTerrain() {
        addParallel(new LiftingArmDown(1));
        addSequential(new EncoderDriveStraight(100)); 
    } 
}
