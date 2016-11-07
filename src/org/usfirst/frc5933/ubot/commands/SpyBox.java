package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpyBox extends CommandGroup {
    public SpyBox() {
        addParallel(new LiftingArmDown(1));

        //Spy Box to Lower Window 1
        addSequential(new EncoderDriveStraight(121));
        addSequential(new EncoderDriveStraight(30));
        addParallel(new ToggleReverseSpindle(4));
    } 
}
