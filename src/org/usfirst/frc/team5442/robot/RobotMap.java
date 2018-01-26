package org.usfirst.frc.team5442.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**For example to map the left and right motors, you could define the
	 * following variables to use with your drivetrain subsystem.
	 * public static int leftMotor = 1;
	 * public static int rightMotor = 2;
	 * 
	 * If you are using multiple modules, make sure to define both the port
	 * number and the module. For example you with a rangefinder:
	 * public static int rangefinderPort = 1;
	 * public static int rangefinderModule = 1;
	 */

	private static DifferentialDrive driveTrain;
	// Declare Motor Controllers Here
	// FORMAT:
	// public static [Controller type] (name);
	public static VictorSP leftController1;
	public static VictorSP leftController2;
	public static VictorSP leftController3;
	public static VictorSP rightController1;
	public static VictorSP rightController2;
	public static VictorSP rightController3;
	public static VictorSP winchMotor;
	
	public static Compressor compressor;
	
	public static DoubleSolenoid gearShiftLeft;
	public static DoubleSolenoid gearShiftRight;
    public static PowerDistributionPanel pdp;
    
    public static Solenoid winchCylinder;
    public static Solenoid latchCylinder;
    
    public static DigitalInput limitSwitch;
    public static DigitalInput limitSwitch2;
    public static DigitalInput windSwitch;
    
	// Setting SpeedControllerGroups per side
	SpeedControllerGroup leftControllers,rightControllers;
	
	public RobotMap() {
		// Setting port numbers for speed controllers
		rightController1 = new VictorSP(0);
		rightController2 = new VictorSP(1);
		rightController3 = new VictorSP(2);
		leftController1 = new VictorSP(5);
		leftController2 = new VictorSP(6);
		leftController3 = new VictorSP(7);
		
		// Setting speed controllers to their respective groups
		leftControllers = new SpeedControllerGroup(leftController1, leftController2, leftController3);
		rightControllers = new SpeedControllerGroup(rightController1, rightController2, rightController3);
		
		gearShiftLeft = new DoubleSolenoid(0, 1);
		gearShiftRight = new DoubleSolenoid(2, 3);
		
		driveTrain = new DifferentialDrive(leftControllers, rightControllers);
		// Needs port number
		winchMotor = new VictorSP(-1);
		

		winchCylinder = new Solenoid(-1);
		latchCylinder = new Solenoid(-1);
		
		compressor = new Compressor();
		
		windSwitch = new DigitalInput(-1);
		//Turn on if debugging
		pdp = new PowerDistributionPanel(1);
	}
	
	public static DifferentialDrive GetDriver()
	{
		return driveTrain;
	}
}
