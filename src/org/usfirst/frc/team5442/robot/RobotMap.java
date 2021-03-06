

package org.usfirst.frc.team5442.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
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

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static DifferentialDrive driveTrain;

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
	
	public static VictorSP leftController1;
	public static VictorSP leftController2;
	public static VictorSP leftController3;
	public static VictorSP rightController1;
	public static VictorSP rightController2;
	public static VictorSP rightController3;
	public static VictorSP catapultMotor;
	public static VictorSP winchMotor;
	public static VictorSP telescopeMotor;
	public static VictorSP hookMotor;
	public static VictorSP leftIntake;
	public static VictorSP rightIntake;
	public static VictorSP flipper;
	
	
	public static Compressor compressor;
	public static DoubleSolenoid gearShift;
    public static Solenoid winchCylinder;
    public static DoubleSolenoid latchCylinder;
    public static DoubleSolenoid pincer;
	public static DoubleSolenoid shooterLatch;

    public static PowerDistributionPanel pdp;
    
    public static DigitalInput limitSwitch;
    public static DigitalInput limitSwitch2;
    public static DigitalInput windSwitch;
    public static DigitalInput latchSwitch1;
    public static DigitalInput catapultSwitch;
	public static DigitalInput backFlipStop;
	public static DigitalInput frontFlipStop;
	public static DigitalInput intakeLimitSwitch;

    
	// Setting SpeedControllerGroups per side
	static SpeedControllerGroup leftControllers;
	static SpeedControllerGroup rightControllers;
	
	public static Encoder flipEncoder;
	public static Encoder encoderLeft;
	public static Encoder encoderRight;
	
	public static AHRS navx;

	
	public RobotMap() {
		// Setting port numbers for speed controllers
		/*
		rightController1 = new VictorSP(0);
		rightController2 = new VictorSP(1);
		rightController3 = new VictorSP(2);
		leftController1 = new VictorSP(6);
		leftController2 = new VictorSP(7);
		leftController3 = new VictorSP(8);
		
		spinRodMotor = new VictorSP(3);
		telescopeMotor = new VictorSP(11);
		hookMotor = new VictorSP(9);
		//Intake
		leftIntake = new VictorSP(5);
		rightIntake = new VictorSP(4);
		flipper = new VictorSP(10);		
		*/
		
		
		rightController1 = new VictorSP(0);
		rightController2 = new VictorSP(1); // This is above 9 b/c the navx code will just check to make sure that it is 
		rightController3 = new VictorSP(2); // ^ That applies here too
		leftController1 = new VictorSP(6);
		leftController2 = new VictorSP(7);
		leftController3 = new VictorSP(8);
		
		catapultMotor = new VictorSP(3);
		telescopeMotor = new VictorSP(10);
		hookMotor = new VictorSP(9);
		//Intake
		leftIntake = new VictorSP(4);
		rightIntake = new VictorSP(5);
		flipper = new VictorSP(11);	
		 
		
		gearShift = new DoubleSolenoid(0, 1);
		pincer = new DoubleSolenoid(2, 3);
		shooterLatch = new DoubleSolenoid(6, 7);
		latchCylinder = new DoubleSolenoid(4, 5);
		
		leftControllers = new SpeedControllerGroup(leftController1, leftController2, leftController3);
		rightControllers = new SpeedControllerGroup(/*rightController1, */rightController2, rightController3);
	
		driveTrain = new DifferentialDrive(leftControllers, rightControllers);
		
		compressor = new Compressor();
	
		//Turn on if debugging
		//pdp = new PowerDistributionPanel(1);
		
		//backFlipStop = new DigitalInput(1);
		//frontFlipStop = new DigitalInput(4);
		//latchSwitch1 = new DigitalInput(2);
		catapultSwitch = new DigitalInput(2);
		intakeLimitSwitch = new DigitalInput(0);
		
		flipEncoder = new Encoder(8, 9, false, EncodingType.k4X);
        flipEncoder.setSamplesToAverage(5);
        flipEncoder.setDistancePerPulse(1.0/360);
		

		navx = new AHRS(SerialPort.Port.kMXP);
		
		//encoders
		encoderLeft = new Encoder(6, 7, false, EncodingType.k4X);
		encoderLeft.setSamplesToAverage(5);
		encoderLeft.setDistancePerPulse(1.0/360);
		
		encoderRight = new Encoder(4, 5, false, EncodingType.k4X);
		encoderRight.setSamplesToAverage(5);
		encoderRight.setDistancePerPulse(1.0/360);
	}
	
	public static DifferentialDrive GetDriver()
	{
		return driveTrain;
	}
}
