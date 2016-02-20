// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.ubot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5933.ubot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public JoystickButton aButton;
    public JoystickButton bButton;
    public JoystickButton xButton;
    public JoystickButton backButton;
    public JoystickButton startButton;
    public JoystickButton leftJoystickButton;
    public JoystickButton rightJoystickButton;
    public JoystickButton yButton;
    public Joystick xBoxJoystick;
    public JoystickButton leftBumper2;
    public JoystickButton rightBumper2;
    public JoystickButton aButton2;
    public JoystickButton bButton2;
    public JoystickButton xButton2;
    public JoystickButton backButton2;
    public JoystickButton startButton2;
    public JoystickButton leftJoystickButton2;
    public JoystickButton rightJoystickButton2;
    public JoystickButton yButton2;
    public Joystick xBoxJoystick2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xBoxJoystick2 = new Joystick(1);
        
        yButton2 = new JoystickButton(xBoxJoystick2, 4);
        yButton2.whenPressed(new NullCommand());
        rightJoystickButton2 = new JoystickButton(xBoxJoystick2, 10);
        rightJoystickButton2.whileHeld(new LiftingArmMove());
        leftJoystickButton2 = new JoystickButton(xBoxJoystick2, 9);
        leftJoystickButton2.whenPressed(new ToggleCamera());
        startButton2 = new JoystickButton(xBoxJoystick2, 8);
        startButton2.whileHeld(new NullCommand());
        backButton2 = new JoystickButton(xBoxJoystick2, 7);
        backButton2.whileHeld(new NullCommand());
        xButton2 = new JoystickButton(xBoxJoystick2, 3);
        xButton2.whenPressed(new NullCommand());
        bButton2 = new JoystickButton(xBoxJoystick2, 2);
        bButton2.whenPressed(new NullCommand());
        aButton2 = new JoystickButton(xBoxJoystick2, 1);
        aButton2.whenPressed(new NullCommand());
        rightBumper2 = new JoystickButton(xBoxJoystick2, 6);
        rightBumper2.whileHeld(new LiftingArmDown());
        leftBumper2 = new JoystickButton(xBoxJoystick2, 5);
        leftBumper2.whileHeld(new LiftingArmUp());
        xBoxJoystick = new Joystick(0);
        
        yButton = new JoystickButton(xBoxJoystick, 4);
        yButton.whenPressed(new Align0());
        rightJoystickButton = new JoystickButton(xBoxJoystick, 10);
        rightJoystickButton.whileHeld(new LiftingArmMove());
        leftJoystickButton = new JoystickButton(xBoxJoystick, 9);
        leftJoystickButton.whenPressed(new ToggleCamera());
        startButton = new JoystickButton(xBoxJoystick, 8);
        startButton.whenPressed(new ToggleTurbo());
        backButton = new JoystickButton(xBoxJoystick, 7);
        backButton.whenPressed(new ReverseControls());
        xButton = new JoystickButton(xBoxJoystick, 3);
        xButton.whenPressed(new Align180());
        bButton = new JoystickButton(xBoxJoystick, 2);
        bButton.whenPressed(new NullCommand());
        aButton = new JoystickButton(xBoxJoystick, 1);
        aButton.whenPressed(new NullCommand());
        rightBumper = new JoystickButton(xBoxJoystick, 6);
        rightBumper.whileHeld(new LiftingArmDown());
        leftBumper = new JoystickButton(xBoxJoystick, 5);
        leftBumper.whileHeld(new LiftingArmUp());


        // SmartDashboard Buttons
        SmartDashboard.putData("DriveStraight", new DriveStraight(-1.0, 157.0));
        SmartDashboard.putData("TurnDegrees", new TurnDegrees());
        SmartDashboard.putData("DeliverBallToLowerWindow", new DeliverBallToLowerWindow());
        SmartDashboard.putData("Align0", new Align0());
        SmartDashboard.putData("Align180", new Align180());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXBoxJoystick() {
        return xBoxJoystick;
    }

    public Joystick getXBoxJoystick2() {
        return xBoxJoystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    public JoystickButton getAButton() {
        return aButton;
    }

    public JoystickButton getBButton() {
        return bButton;
    }

    public JoystickButton getAButton2() {
        return aButton2;
    }

    public JoystickButton getBButton2() {
        return bButton2;
    }
}

