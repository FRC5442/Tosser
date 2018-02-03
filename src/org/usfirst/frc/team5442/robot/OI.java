package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commands.FlipBack;
import org.usfirst.frc.team5442.robot.commands.FlipForward;
import org.usfirst.frc.team5442.robot.commands.FlipToAngle;
import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.IntakeIn;
import org.usfirst.frc.team5442.robot.commands.IntakeOut;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.commands.PincerIn;
import org.usfirst.frc.team5442.robot.commands.PincerOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

	public static Joystick xboxJoystick;
	public static JoystickButton leftBumper;
	public static JoystickButton rightBumper;
	public static JoystickButton A_Button;
	public static JoystickButton B_Button;
	public static JoystickButton X_Button;
	public static JoystickButton Y_Button;
	
	public static Joystick xboxJoystick2;
	public static JoystickButton leftBumper2;
	public static JoystickButton rightBumper2;
	public static JoystickButton A_Button2;
	public static JoystickButton B_Button2;
	public static JoystickButton X_Button2;
	public static JoystickButton Y_Button2;
	
	public OI(){
		//xboxController = new XboxController(1);
		
		//Remove all xboxJoystick stuff when we replace with XboxController
		
		//Driver Joystick 1
		xboxJoystick = new Joystick(0);
		leftBumper = new JoystickButton(xboxJoystick, 5);
		rightBumper = new JoystickButton(xboxJoystick, 6);
		A_Button = new JoystickButton(xboxJoystick, 1);
		B_Button = new JoystickButton(xboxJoystick, 2);
		X_Button = new JoystickButton(xboxJoystick, 3);
		Y_Button = new JoystickButton(xboxJoystick, 4);
		
		//Control Joystick 2
		xboxJoystick2 = new Joystick(1);
		leftBumper2 = new JoystickButton(xboxJoystick2, 5);
		rightBumper2 = new JoystickButton(xboxJoystick2, 6);
		A_Button2 = new JoystickButton(xboxJoystick2, 1);
		B_Button2 = new JoystickButton(xboxJoystick2, 2);
		X_Button2 = new JoystickButton(xboxJoystick2, 3);
		Y_Button2 = new JoystickButton(xboxJoystick2, 4);
		
		
		
		//Driver Joystick 1
		leftBumper.whileHeld(new HighShift());
		rightBumper.whileHeld(new LowShift());
		B_Button.whileHeld(new FlipToAngle(1));
		
		//Control Joystick 2
		leftBumper2.whileHeld(new PincerOut());
		rightBumper2.whileHeld(new PincerIn());
		A_Button2.whileHeld(new IntakeIn(1));
		B_Button2.whileHeld(new IntakeOut(1));
		X_Button2.whileHeld(new FlipBack(.5));
		Y_Button2.whileHeld(new FlipForward(.5));
	}
		
}
