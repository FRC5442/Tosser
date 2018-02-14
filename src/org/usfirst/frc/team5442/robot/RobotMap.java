
package org.usfirst.frc.team5442.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	/*
	public static VictorSP leftController1;
	public static VictorSP leftController2;
	public static VictorSP leftController3;
	public static VictorSP rightController1;
	public static VictorSP rightController2;
	public static VictorSP rightController3;
	public static VictorSP spinRodMotor;
	public static VictorSP winchMotor;
	public static VictorSP telescopeMotor;
	public static VictorSP hookMotor;
	public static VictorSP leftIntake;
	public static VictorSP rightIntake;
	public static VictorSP flipper;
	*/
	public static Spark leftController1;
	public static Spark leftController2;
	public static Spark leftController3;
	public static Spark rightController1;
	public static Spark rightController2;
	public static Spark rightController3;
	public static Spark spinRodMotor;
	public static Spark winchMotor;
	public static Spark telescopeMotor;
	public static Spark hookMotor;
	public static Spark leftIntake;
	public static Spark rightIntake;
	public static Spark flipper;
	public static Compressor compressor;
	
	public static DoubleSolenoid gearShift;
    public static PowerDistributionPanel pdp1;
    
    public static DigitalInput limitSwitch;
    public static DigitalInput limitSwitch2;
    public static DigitalInput windSwitch;
    public static DigitalInput latchSwitch1;
    public static DigitalInput latchSwitch2;
    
    
    public static Solenoid winchCylinder;
    public static DoubleSolenoid latchCylinder;
   
    
	// Setting SpeedControllerGroups per side
	static SpeedControllerGroup leftControllers;
	static SpeedControllerGroup rightControllers;
	
	public static DoubleSolenoid pincer;
	
	public static Encoder FlipEncoder;
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;
	
	public static DigitalInput backFlipStop;
	public static DigitalInput frontFlipStop;
	
	public static PowerDistributionPanel pdp;
	
	public static void init() {
		// Setting port numbers for speed controllers
		/*
		rightController1 = new VictorSP(0);
		rightController2 = new VictorSP(10);
		rightController3 = new VictorSP(11);
		leftController1 = new VictorSP(3);
		leftController2 = new VictorSP(4);
		leftController3 = new VictorSP(5);
		
		spinRodMotor = new VictorSP(6);
		telescopeMotor = new VictorSP(1);
		hookMotor = new VictorSP(2);
		//Intake
		leftIntake = new VictorSP(9);
		rightIntake = new VictorSP(8);
		flipper = new VictorSP(7);		
		*/
		rightController1 = new Spark(0);
		rightController2 = new Spark(10); // This is above 9 b/c the navx code will just check to make sure that it is 
		rightController3 = new Spark(11); // ^ That applies here too
		leftController1 = new Spark(3);
		leftController2 = new Spark(4);
		leftController3 = new Spark(5);
		
		spinRodMotor = new Spark(6);
		telescopeMotor = new Spark(1);
		hookMotor = new Spark(2);
		//Intake
		leftIntake = new Spark(9);
		rightIntake = new Spark(8);
		flipper = new Spark(7);	
		
		gearShift = new DoubleSolenoid(0, 1);
		pincer = new DoubleSolenoid(2, 3);
		latchCylinder = new DoubleSolenoid(4, 5);
		
		leftControllers = new SpeedControllerGroup(leftController1, leftController2, leftController3);
		rightControllers = new SpeedControllerGroup(rightController1, rightController2, rightController3);
	
		driveTrain = new DifferentialDrive(leftControllers, rightControllers);
		
		//latchSwitch1 = new DigitalInput(-1);
		//latchSwitch2 = new DigitalInput(-1);
		
		compressor = new Compressor();
	
		//Turn on if debugging
		//pdp = new PowerDistributionPanel(1);
		
		//backFlipStop = new DigitalInput(-1);
		//frontFlipStop = new DigitalInput(-1);
		
		//FlipEncoder = new Encoder(-1, -1, false, EncodingType.k4X);
        //FlipEncoder.setSamplesToAverage(5);
        //FlipEncoder.setDistancePerPulse(1.0/360);
		
		leftEncoder = new Encoder(8, 9, false, EncodingType.k4X);
		leftEncoder.setSamplesToAverage(5);
		leftEncoder.setDistancePerPulse(1.0/360);
		leftEncoder.reset();
		
		rightEncoder = new Encoder(6, 7, false, EncodingType.k4X);
		rightEncoder.setSamplesToAverage(5);
		rightEncoder.setDistancePerPulse(1.0/360);
		rightEncoder.reset();
		
	}
	
	public static DifferentialDrive GetDriver()
	{
		return driveTrain;
	}
}
