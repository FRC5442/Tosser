package org.usfirst.frc.team5442.robot;

import java.io.Console;

import org.usfirst.frc.team5442.robot.commands.HighShift;
import org.usfirst.frc.team5442.robot.commands.LowShift;
import org.usfirst.frc.team5442.robot.commands.RumbleRight;
import org.usfirst.frc.team5442.robot.commands.SelectArcadeDrive;
import org.usfirst.frc.team5442.robot.commands.SelectTankDrive;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.Wind;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
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
	//public static XboxController xboxController2;
	//Controller 1 buttons
	public static JoystickButton xboxLBumper;
	public static JoystickButton xboxRBumper;
	
	//Controller 2 buttons
	public static JoystickButton xbox2AButton;
	public static JoystickButton xbox2XButton;

	public static JoystickButton xboxLeftJoyButton;
	public static JoystickButton xboxRightJoyButton;
	
	public static JoystickButton xboxButtonB;
	
	public OI(){
		//xboxController = new XboxController(1);
		
		//Remove all xboxJoystick stuff when we replace with XboxController
		
		// Assign Joysticks and their ports
		xboxController1 = new XboxController(0);
		//xboxController2 = new XboxController(1);
		
		// Assign button names to mapping to Controller 1
		xboxLBumper = new JoystickButton(xboxController1, 5);
		xboxRBumper = new JoystickButton(xboxController1, 6);
		
		// Assign button names to mapping to Controller 2
		xbox2AButton = new JoystickButton(xboxController1, 1);
		xbox2XButton = new JoystickButton(xboxController1, 3);
		
		xboxLeftJoyButton = new JoystickButton(xboxController1, 10);
		xboxRightJoyButton = new JoystickButton(xboxController1, 9);
		
		xboxButtonB = new JoystickButton(xboxController1, 2);

		// Assign commands to buttons
		xboxLBumper.whileHeld(new HighShift());
		xboxRBumper.whileHeld(new LowShift());
		xbox2AButton.whileHeld(new Wind());
		xbox2XButton.whileHeld(new Shoot());
		xboxLeftJoyButton.toggleWhenPressed(new SelectArcadeDrive());
		xboxRightJoyButton.toggleWhenPressed(new SelectTankDrive());
		xboxButtonB.whileHeld(new RumbleRight());
		
	}
	public XboxController getXboxController1() {
        return xboxController1;
    }
	//public XboxController getXboxController2() {
    //    return xboxController2;
    //}
	public static void setRumbleRight(double power) {
		//System.console().printf("Rumble!!");
		xboxController1.setRumble(RumbleType.kRightRumble, power);
	}
}

