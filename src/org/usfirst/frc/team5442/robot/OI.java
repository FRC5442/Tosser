package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commands.ArmLatch;
import org.usfirst.frc.team5442.robot.commands.FlipBack;
import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.IntakeIn;
import org.usfirst.frc.team5442.robot.commands.IntakeOut;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.commands.PincerIn;
import org.usfirst.frc.team5442.robot.commands.PincerOut;
import org.usfirst.frc.team5442.robot.commands.Shoot;

import edu.wpi.first.wpilibj.GenericHID;
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
	public static XboxController xboxController2;
	//Controller 1 buttons
	public JoystickButton xboxLBumper;
	public JoystickButton xboxRBumper;
	
	public JoystickButton xboxAButton;
	public JoystickButton xboxBButton;
	public JoystickButton xboxXButton;
	public JoystickButton xboxYButton;
	public JoystickButton xboxBack;
	public JoystickButton xboxStart;
	
	//Controller 2 buttons
	public JoystickButton xboxLBumper2;
	public JoystickButton xboxRBumper2;
	
	public JoystickButton xboxAButton2;
	public JoystickButton xboxBButton2;
	public JoystickButton xboxXButton2;
	public JoystickButton xboxYButton2;
	public JoystickButton xboxBack2;
	public JoystickButton xboxStart2;
	
	public OI(){		
		// Assign Joysticks and their ports
		xboxController1 = new XboxController(0);
		xboxController2 = new XboxController(1);
		
		//Controller 1
		xboxLBumper = new JoystickButton(xboxController1, 5);
		xboxRBumper = new JoystickButton(xboxController1, 6);
		
		xboxAButton = new JoystickButton(xboxController1, 1);
		xboxBButton = new JoystickButton(xboxController1, 2);
		xboxXButton = new JoystickButton(xboxController1, 3);
		xboxYButton = new JoystickButton(xboxController1, 4);
		xboxBack = new JoystickButton(xboxController1, 7);
		xboxStart = new JoystickButton(xboxController1, 8);
		
		//Controller 2
		xboxLBumper2 = new JoystickButton(xboxController2, 5);
		xboxRBumper2 = new JoystickButton(xboxController2, 6);
		xboxAButton2 = new JoystickButton(xboxController2, 1);
		xboxBButton2 = new JoystickButton(xboxController2, 2);
		xboxXButton2 = new JoystickButton(xboxController2, 3);
		xboxYButton2 = new JoystickButton(xboxController2, 4);
		xboxStart2 = new JoystickButton(xboxController2, 8);
		
		
		//Driver Joystick 1
		xboxLBumper.whileHeld(new HighShift());
		xboxRBumper.whileHeld(new LowShift());
		xboxAButton.whileHeld(new Shoot());
		//xboxBButton.whileHeld(new FlipToAngle(1));
		xboxXButton.whileHeld(new ArmLatch(Math.abs(xboxController1.getTriggerAxis(GenericHID.Hand.kLeft))));
		xboxXButton.whileHeld(new ArmLatch(-1* Math.abs(xboxController1.getTriggerAxis(GenericHID.Hand.kRight))));
		xboxBack.whileHeld(new ArmLatch(1));
		xboxStart.whileHeld(new ArmLatch(-1));
		
		//Control Joystick 2
		xboxLBumper2.whileHeld(new PincerOut());
		xboxRBumper2.whileHeld(new PincerIn());
		xboxAButton2.whileHeld(new IntakeIn(1));
		xboxBButton2.whileHeld(new IntakeOut(1));
		xboxXButton2.whileHeld(new FlipBack(-1));
		xboxStart2.whileHeld(new FlipBack(1));
		//xboxYButton2.whileHeld(new FlipForward(1));
		
		
	}
	public XboxController getXboxController1() {
        return xboxController1;
    }
	public XboxController getXboxController2() {
        return xboxController2;
    }

}

