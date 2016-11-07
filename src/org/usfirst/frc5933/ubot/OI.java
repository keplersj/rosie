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

    private JoystickButton aButton;
    private JoystickButton bButton;
    private JoystickButton xButton;
    private JoystickButton yButton;
    private Joystick xBoxJoystick;
    private JoystickButton aButton2;
    private JoystickButton bButton2;
    private JoystickButton xButton2;
    public JoystickButton rightJoystickButton2;
    private JoystickButton yButton2;
    private Joystick xBoxJoystick2;

    OI() {
        xBoxJoystick2 = new Joystick(1);

        yButton2 = new JoystickButton(xBoxJoystick2, 4);
        yButton2.whenPressed(new NullCommand());
        rightJoystickButton2 = new JoystickButton(xBoxJoystick2, 10);
        rightJoystickButton2.whileHeld(new LiftingArmMove());
        JoystickButton leftJoystickButton2 = new JoystickButton(xBoxJoystick2, 9);
        leftJoystickButton2.whenPressed(new NullCommand());
        JoystickButton startButton2 = new JoystickButton(xBoxJoystick2, 8);
        startButton2.whileHeld(new NullCommand());
        JoystickButton backButton2 = new JoystickButton(xBoxJoystick2, 7);
        backButton2.whileHeld(new NullCommand());
        xButton2 = new JoystickButton(xBoxJoystick2, 3);
        xButton2.whenPressed(new NullCommand());
        bButton2 = new JoystickButton(xBoxJoystick2, 2);
        bButton2.whenPressed(new NullCommand());
        aButton2 = new JoystickButton(xBoxJoystick2, 1);
        aButton2.whenPressed(new NullCommand());
        JoystickButton rightBumper2 = new JoystickButton(xBoxJoystick2, 6);
        rightBumper2.whileHeld(new LiftingArmDown());
        JoystickButton leftBumper2 = new JoystickButton(xBoxJoystick2, 5);
        leftBumper2.whileHeld(new LiftingArmUp());
        xBoxJoystick = new Joystick(0);

        yButton = new JoystickButton(xBoxJoystick, 4);
        yButton.whenPressed(new NullCommand());
        JoystickButton rightJoystickButton = new JoystickButton(xBoxJoystick, 10);
        rightJoystickButton.whileHeld(new LiftingArmMove());
        JoystickButton leftJoystickButton = new JoystickButton(xBoxJoystick, 9);
        leftJoystickButton.whenPressed(new NullCommand());
        JoystickButton startButton = new JoystickButton(xBoxJoystick, 8);
        startButton.whenPressed(new ToggleTurbo());
        JoystickButton backButton = new JoystickButton(xBoxJoystick, 7);
        backButton.whenPressed(new ReverseControls());
        xButton = new JoystickButton(xBoxJoystick, 3);
        xButton.whenPressed(new NullCommand());
        bButton = new JoystickButton(xBoxJoystick, 2);
        bButton.whenPressed(new NullCommand());
        aButton = new JoystickButton(xBoxJoystick, 1);
        aButton.whenPressed(new NullCommand());
        JoystickButton rightBumper = new JoystickButton(xBoxJoystick, 6);
        rightBumper.whileHeld(new LiftingArmDown());
        JoystickButton leftBumper = new JoystickButton(xBoxJoystick, 5);
        leftBumper.whileHeld(new LiftingArmUp());


        // SmartDashboard Buttons
        SmartDashboard.putData("GyroDriveStraight", new GyroDriveStraight());
    }

    public Joystick getXBoxJoystick() {
        return xBoxJoystick;
    }

    public Joystick getXBoxJoystick2() {
        return xBoxJoystick2;
    }

    JoystickButton getAButton() {
        return aButton;
    }

    JoystickButton getBButton() {
        return bButton;
    }

    JoystickButton getAButton2() {
        return aButton2;
    }

    JoystickButton getBButton2() {
        return bButton2;
    }
    JoystickButton getXButton() {
        return xButton;
    }
    JoystickButton getXButton2() {
        return xButton2;
    }
    JoystickButton getYButton() {
        return yButton;
    }
    JoystickButton getYButton2() {
        return yButton2;
    }
}

