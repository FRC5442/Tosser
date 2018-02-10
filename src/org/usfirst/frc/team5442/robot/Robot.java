
package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commands.*;
import org.usfirst.frc.team5442.robot.subsystems.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Pneumatics pneumatics;
	public static Cylinders cylinders;
	public static Climber climber;
	public static Intake intake;

	Command autonomousCommand;
	SendableChooser<Command> driveChooser;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	public void robotInit() {
		// Initialize variables 
		RobotMap.init();
		oi = new OI();
		driveTrain = new DriveTrain();
		driveChooser = new SendableChooser<>();
		// Add objects to "driveChooser" sendablechooser on shuffleboard/smartdashboard
		driveChooser.addDefault("Tank Drive", new TankDrive());
		driveChooser.addObject("Arcade Drive", new ArcadeDrive());
		//driveChooser.addObject("My Auto", new MyAutoCommand());
		//driveChooser.addObject("My Auto", new MyAutoCommand());
		//driveChooser.addObject("My Auto", new MyAutoCommand());

		SmartDashboard.putData("Drive mode", driveChooser);
	
		pneumatics = new Pneumatics();
		climber = new Climber();
		intake = new Intake();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		RobotMap.FlipEncoder.reset();
		
		//autonomousCommand = chooser.getSelected(); Change this when we get auto code

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.getNumber("FlipEncoder", RobotMap.FlipEncoder.getDistance());
	}

	@Override
	public void teleopInit() {
		
		/** This makes sure that the autonomous stops running when teleop starts running. 
		 * If you want the autonomous to continue until interrupted by another command, remove this line or comment it out.
		 */
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// Putting PDP output onto smartdashboard/shuffleboard
		Scheduler.getInstance().run();
		
		boolean pdpVoltage = RobotMap.pdp.getVoltage() <= 12;
		
		SmartDashboard.putNumber("PDP0", RobotMap.pdp.getCurrent(0));

		SmartDashboard.putNumber("PDP1", RobotMap.pdp.getCurrent(1));
		SmartDashboard.putNumber("PDP2", RobotMap.pdp.getCurrent(2));
		SmartDashboard.putNumber("PDP5", RobotMap.pdp.getCurrent(5));
		SmartDashboard.putNumber("PDP6", RobotMap.pdp.getCurrent(6));
		SmartDashboard.putNumber("PDP7", RobotMap.pdp.getCurrent(7));
		SmartDashboard.putBoolean("PDP Voltage Less Than 12", pdpVoltage);

		if(Timer.getMatchTime() >= 120 && RobotMap.compressor.enabled()) {
			new CompressorToggle().start();
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
