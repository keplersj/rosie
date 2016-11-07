package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos4RoughTerrain extends CommandGroup {
    public Pos4RoughTerrain() {
        addParallel(new LiftingArmDown(1));
        addSequential(new EncoderDriveStraight(100));
    } 
}
