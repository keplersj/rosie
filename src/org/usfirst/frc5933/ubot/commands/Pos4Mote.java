package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Pos4Mote extends CommandGroup {
    public Pos4Mote() {
        addParallel(new LiftingArmDown(1));
        addSequential(new EncoderDriveStraight(100));
    } 
}
