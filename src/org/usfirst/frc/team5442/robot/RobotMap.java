package org.usfirst.frc.team5442.robot;

<<<<<<< HEAD
=======

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
>>>>>>> ab60edd134c9951490d92ba15df6d87d3473504b
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
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	private static DifferentialDrive driveTrain;
	// Declare Motor Controllers Here
	public static VictorSP leftController1;
	public static VictorSP leftController2;
	public static VictorSP leftController3;
	public static VictorSP rightController1;
	public static VictorSP rightController2;
	public static VictorSP rightController3;
<<<<<<< HEAD
		
=======
	
	public static Compressor compressor;
	
	public static DoubleSolenoid gearShiftLeft;
	public static DoubleSolenoid gearShiftRight;
>>>>>>> ab60edd134c9951490d92ba15df6d87d3473504b
	// Setting SpeedControllerGroups per side
	SpeedControllerGroup leftControllers,rightControllers;
	
	public static PowerDistributionPanel pdp;
	
	public RobotMap() {
		// Setting port numbers for speed controllers
<<<<<<< HEAD
		leftController1 = new VictorSP(0);
		leftController2 = new VictorSP(1);
		leftController3 = new VictorSP(2);
		rightController1 = new VictorSP(3);
		rightController2 = new VictorSP(4);
		rightController3 = new VictorSP(5);
=======
		leftController1 = new VictorSP(5);
		leftController2 = new VictorSP(6);
		leftController3 = new VictorSP(7);
		rightController1 = new VictorSP(0);
		rightController2 = new VictorSP(1);
		rightController3 = new VictorSP(2);
>>>>>>> ab60edd134c9951490d92ba15df6d87d3473504b
		// Setting speed controllers to their respective groups
		leftControllers = new SpeedControllerGroup(leftController1, leftController2, leftController3);
		rightControllers = new SpeedControllerGroup(rightController1, rightController2, rightController3);
		
		driveTrain = new DifferentialDrive(leftControllers, rightControllers);
		
<<<<<<< HEAD
=======
		compressor = new Compressor();
		gearShiftLeft = new DoubleSolenoid(0, 1);
		gearShiftRight = new DoubleSolenoid(2, 3);
		
		pdp = new PowerDistributionPanel();
>>>>>>> ab60edd134c9951490d92ba15df6d87d3473504b
	}
	
	public static DifferentialDrive GetDriver()
	{
		return driveTrain;
	}
}
