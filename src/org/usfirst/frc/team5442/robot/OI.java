package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commandgroups.Reload;
import org.usfirst.frc.team5442.robot.commands.ArmingCatapult;
import org.usfirst.frc.team5442.robot.commands.CatapultLatch;
import org.usfirst.frc.team5442.robot.commands.Climber_Hook;
import org.usfirst.frc.team5442.robot.commands.CompressorToggle;
import org.usfirst.frc.team5442.robot.commands.FlipExecutable;
import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.IntakeIn;
import org.usfirst.frc.team5442.robot.commands.IntakeOut;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.commands.PincerToggle;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.SwitchHeading;
import org.usfirst.frc.team5442.robot.commands.Telescope;

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
	public JoystickButton xboxBButton;
	public JoystickButton xboxAButton;
	public JoystickButton xboxXButton;
	public JoystickButton xboxLeftJoybutton;
	
	
	//Controller 2 buttons
	public JoystickButton Button1;
	public JoystickButton Button2;
	public JoystickButton Button3;
	public JoystickButton Button4;
	public JoystickButton Button5;	
	public JoystickButton Button6;
	public JoystickButton Button7;
	public JoystickButton Button8;
	public JoystickButton Button9;
	public JoystickButton Button10;
	public JoystickButton Button11;
	public JoystickButton Button12;

	
	public OI(){		
		// Assign Joysticks and their ports
		xboxController1 = new XboxController(0);
		Controller2 = new Joystick(1);
		
		//Controller 1
		xboxLBumper = new JoystickButton(xboxController1, 5);
		xboxRBumper = new JoystickButton(xboxController1, 6);
		xboxBButton = new JoystickButton(xboxController1, 2);
		xboxAButton = new JoystickButton(xboxController1, 1);
		xboxXButton = new JoystickButton(xboxController1, 3);
		xboxLeftJoybutton = new JoystickButton(xboxController1, 10);
		

		//Controller 2
		Button1 = new JoystickButton(Controller2, 1);
		Button2 = new JoystickButton(Controller2, 2);
		Button3 = new JoystickButton(Controller2, 3);
		Button4 = new JoystickButton(Controller2, 4);
		Button5 = new JoystickButton(Controller2, 5);		
		Button6 = new JoystickButton(Controller2, 6);
		Button7 = new JoystickButton(Controller2, 7);
		Button8 = new JoystickButton(Controller2, 8);
		Button9 = new JoystickButton(Controller2, 9);
		Button10 = new JoystickButton(Controller2, 10);
		Button11 = new JoystickButton(Controller2, 11);
		Button12 = new JoystickButton(Controller2, 12);
		
		//Driver Joystick 1
		xboxLBumper.whileHeld(new HighShift());
		xboxRBumper.whileHeld(new LowShift());
		xboxAButton.whileHeld(new Shoot());
		xboxBButton.whenPressed(new Reload());
		xboxXButton.whenPressed(new CompressorToggle());
		xboxLeftJoybutton.whenPressed(new SwitchHeading());
		
		//Control Joystick 2
		Button1.whileHeld(new FlipExecutable());
		Button7.whenPressed(new PincerToggle());
		Button5.whileHeld(new IntakeIn(.85));
		Button3.whileHeld(new IntakeOut(.65));
		Button2.whileHeld(new IntakeOut(.95));
		Button4.whileHeld(new ArmingCatapult(1));
		Button6.whenPressed(new CatapultLatch());
		Button9.whileHeld(new Telescope(1));
		Button10.whileHeld(new Telescope(-1));
		Button11.whileHeld(new Climber_Hook(1));
		Button12.whileHeld(new Climber_Hook(-1));
		
		//xboxYButton2.whileHeld(new FlipForward(1));
		
		//12 loosen
		//11 tighten
	}
	
	public XboxController getXboxController1() {
        return xboxController1;
    }
	public Joystick getXboxController2() {
        return Controller2;
    }

}

