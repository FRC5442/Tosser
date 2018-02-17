package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commands.ArmLatch;
import org.usfirst.frc.team5442.robot.commands.Climber_Hook;
import org.usfirst.frc.team5442.robot.commands.Flip;
import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.IntakeIn;
import org.usfirst.frc.team5442.robot.commands.IntakeOut;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.commands.PincerIn;
import org.usfirst.frc.team5442.robot.commands.PincerOut;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.Telescope;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	/** CREATING BUTTONS
	 *  One type of button is a joystick button which is any button on a
	 *  joystick.
	 *  You create one by telling it which joystick it's on and which button
	 *  number it is.
	 *  Joystick stick = new Joystick(port);
	 *  Button button = new JoystickButton(stick, buttonNumber);
	 *  
	 *  There are a few additional built in buttons you can use. Additionally,
	 *  by subclassing Button you can create custom triggers and bind those to
	 *  commands the same as any other Button.
	 *  
	 *    TRIGGERING COMMANDS WITH BUTTONS
	 *  Once you have a button, it's trivial to bind it to a button in one of
	 *  three ways:
	 *  
	 *  Start the command when the button is pressed and let it run the command
	 *  until it is finished as determined by it's isFinished method.
	 *  button.whenPressed(new ExampleCommand());
	 *   
	 *   Run the command while the button is being held down and interrupt it once
	 *   the button is released.
	 *   button.whileHeld(new ExampleCommand());
	 *   
	 *   Start the command when the button is released and let it run the command
	 *   until it is finished as determined by it's isFinished method.
	 *   button.whenReleased(new ExampleCommand());
	 **/
	
	public static XboxController xboxController1;
	public static Joystick Controller2;
	//Controller 1 buttons
	public JoystickButton xboxLBumper;
	public JoystickButton xboxRBumper;
	public JoystickButton xboxXButton;
	
	
	//Controller 2 buttons
	public JoystickButton Button4;
	public JoystickButton Button6;
	public JoystickButton Button7;
	public JoystickButton Button8;
	public JoystickButton Button3;
	public JoystickButton Button5;
	public JoystickButton Button1;
	public JoystickButton Button9;
	public JoystickButton Button10;
	public JoystickButton Button11;

	
	public OI(){		
		// Assign Joysticks and their ports
		xboxController1 = new XboxController(0);
		Controller2 = new Joystick(1);
		
		//Controller 1
		xboxLBumper = new JoystickButton(xboxController1, 5);
		xboxRBumper = new JoystickButton(xboxController1, 6);
		xboxXButton = new JoystickButton(xboxController1, 1);
		

		//Controller 2
		Button4 = new JoystickButton(Controller2, 4);
		Button6 = new JoystickButton(Controller2, 6);
		Button7 = new JoystickButton(Controller2, 7);
		Button8 = new JoystickButton(Controller2, 8);
		Button3 = new JoystickButton(Controller2, 3);
		Button5 = new JoystickButton(Controller2, 5);
		Button1 = new JoystickButton(Controller2, 1);
		Button9 = new JoystickButton(Controller2, 9);
		Button10 = new JoystickButton(Controller2, 10);
		Button11 = new JoystickButton(Controller2, 11);
		
		
		//Driver Joystick 1
		xboxLBumper.whileHeld(new HighShift());
		xboxRBumper.whileHeld(new LowShift());
		xboxXButton.whileHeld(new Flip());
		if (xboxController1.getTriggerAxis(Hand.kRight) > 0.1)
			new Shoot().start();

		
		//Control Joystick 2
		Button7.whileHeld(new PincerOut());
		Button8.whileHeld(new PincerIn());
		Button3.whileHeld(new IntakeIn(1));
		Button5.whileHeld(new IntakeOut(1));
		Button9.whileHeld(new Telescope(1));
		Button10.whileHeld(new Telescope(-1));
		Button11.whileHeld(new Climber_Hook(1));
		Button4.whileHeld(new ArmLatch(1));
		Button6.whileHeld(new ArmLatch(-1));
		//xboxYButton2.whileHeld(new FlipForward(1));
		
		
	}
	public XboxController getXboxController1() {
        return xboxController1;
    }
	public Joystick getXboxController2() {
        return Controller2;
    }
}

