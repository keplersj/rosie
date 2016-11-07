package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc5933.ubot.Robot;

public class Pos1LowBar extends CommandGroup {
    public Pos1LowBar() {
        requires(Robot.ballGrabberSubsystem);
        Robot.ballGrabberSubsystem.stop();
        addParallel(new LiftingArmDown(.2));
        addSequential(new DriveOverTime(3.5));
        addSequential(new LiftingArmUp(.4));
        addSequential(new EncoderTurnDegrees(-50));
        addSequential(new DriveOverTime(2.75));
        addSequential(new ToggleReverseSpindle());
    } 
}
