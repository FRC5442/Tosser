package org.usfirst.frc.team5442.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	public static Spark leftController1;
	public static Spark leftController2;
	public static Spark rightController1;
	public static Spark rightController2;
	
	public static Compressor compressor;
	
	public static Solenoid gearShift;
	// Setting SpeedControllerGroups per side
	SpeedControllerGroup leftControllers,rightControllers;
	
	public RobotMap() {
		// Setting port numbers for speed controllers
		leftController1 = new Spark(0);
		leftController2 = new Spark(1);
		rightController1 = new Spark(2);
		rightController2 = new Spark(3);
		// Setting speed controllers to their respective groups
		leftControllers = new SpeedControllerGroup(leftController1, leftController2);
		rightControllers = new SpeedControllerGroup(rightController1, rightController2);
		
		driveTrain = new DifferentialDrive(leftControllers, rightControllers);
		
		compressor = new Compressor();
		gearShift = new Solenoid(1);
	}
	
	public static DifferentialDrive GetDriver()
	{
		return driveTrain;
	}
}
