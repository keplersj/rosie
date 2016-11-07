package org.usfirst.frc5933.ubot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5933.ubot.Robot;

public class DriveOverTime extends Command {

    private boolean useSmartDashboard = true;
    private long desiredTime;
    private double seconds;

    public DriveOverTime() {
        requires(Robot.driveTrain);
        if (!useSmartDashboard) {
            seconds = SmartDashboard.getNumber("Time to Drive Straight");
        }
    }

    DriveOverTime(double time) {
        seconds = time;
        useSmartDashboard = true;
    }

    /**
     * The initialize method is called the first time this Command is run after
     * being started.
     */
    @Override
    protected void initialize() {
        desiredTime = System.currentTimeMillis() + (long) (seconds * 1000);
        Robot.driveTrain.configForTeleopMode();
    }

    /**
     * The execute method is called repeatedly until this Command either finishes
     * or is canceled.
     */
    @Override
    protected void execute() {
        Robot.driveTrain.tankDrive(1);
    }

    /**
     * Returns whether this command is finished. If it is, then the command will
     * be removed and {@link Command#end() end()} will be called.
     * <p>
     * <p>
     * It may be useful for a team to reference the {@link Command#isTimedOut()
     * isTimedOut()} method for time-sensitive commands.
     * </p>
     * $
     *
     * @return whether this command is finished.
     * @see Command#isTimedOut() isTimedOut()
     */
    @Override
    protected boolean isFinished() {
        boolean fin = System.currentTimeMillis() < desiredTime;
        return !fin;
    }

    /**
     * Called when the command ended peacefully. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     */
    @Override
    protected void end() {
        Robot.driveTrain.stop();
    }

    /**
     * Called when the command ends because somebody called
     * {@link Command#cancel() cancel()} or another command shared the same
     * requirements as this one, and booted it out.
     * <p>
     * <p>
     * This is where you may want to wrap up loose ends, like shutting off a motor
     * that was being used in the command.
     * </p>
     * <p>
     * <p>
     * Generally, it is useful to simply call the {@link Command#end() end()}
     * method within this method
     * </p>
     */
    @Override
    protected void interrupted() {
        end();
    }
}
