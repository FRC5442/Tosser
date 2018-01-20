package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.triggers.A_Button;
import org.usfirst.frc.team5442.robot.triggers.B_Button;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
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

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static XboxController xboxController;
	public static Joystick xboxJoystick;
	public static JoystickButton leftBumper;
	public static JoystickButton rightBumper;
	
	public OI(){
		//xboxController = new XboxController(1);
		
		//Remove all xboxJoystick stuff when we replace with XboxController
		xboxJoystick = new Joystick(0);
		leftBumper = new JoystickButton(xboxJoystick, 5);
		rightBumper = new JoystickButton(xboxJoystick, 6);
		
		leftBumper.whileHeld(new HighShift());
		rightBumper.whileHeld(new LowShift());
		
	}
	
	
	public XboxController getXboxController(){
		return xboxController;
	}
}
