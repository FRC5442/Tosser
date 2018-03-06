
package org.usfirst.frc.team5442.robot;

import org.usfirst.frc.team5442.robot.commandgroups.DriveAndStop;
import org.usfirst.frc.team5442.robot.commands.ArcadeDrive;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.TankDrive;
import org.usfirst.frc.team5442.robot.commands.autonomous.CrossMiddle;
import org.usfirst.frc.team5442.robot.commands.autonomous.CrossMiddleChoice;
import org.usfirst.frc.team5442.robot.commands.autonomous.EnableSecondary;
import org.usfirst.frc.team5442.robot.commands.autonomous.EnableSecondaryChoice;
import org.usfirst.frc.team5442.robot.commands.autonomous.FlowChartChooser;
import org.usfirst.frc.team5442.robot.commands.autonomous.OurSide;
import org.usfirst.frc.team5442.robot.commands.autonomous.OurSideChoice;
import org.usfirst.frc.team5442.robot.commands.autonomous.PrimaryObjective;
import org.usfirst.frc.team5442.robot.commands.autonomous.PrimaryObjectiveChoice;
import org.usfirst.frc.team5442.robot.subsystems.Climber;
import org.usfirst.frc.team5442.robot.subsystems.Cylinders;
import org.usfirst.frc.team5442.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5442.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5442.robot.subsystems.Intake;
//import org.usfirst.frc.team5442.robot.subsystems.PIDDrive;
//import org.usfirst.frc.team5442.robot.subsystems.PIDTurn;
import org.usfirst.frc.team5442.robot.subsystems.Pneumatics;

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
	public static RobotMap robotMap;
	public static DriveTrain driveTrain;
	public static Pneumatics pneumatics;

	//public static PIDDrive pidDrive;
	//public static PIDTurn pidTurn;
	public static Cylinders cylinders;
	public static Climber climber;
	public static Intake intake;
	
	public static FlowChartChooser autonomousFlowchart;

	//Command autonomousCommand;
	SendableChooser<Command> driveChooser;
	SendableChooser<Command> ourSide;
	SendableChooser<Command> primaryObjective;
	SendableChooser<Command> enableSecondary;
	SendableChooser<Command> crossMiddle;
 	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	public void robotInit() {
		// Initialize variables 
		//RobotMap.init();
		oi = new OI();
		robotMap = new RobotMap();
		//driveTrain = new DriveTrain();
		pneumatics = new Pneumatics();
		
		//pidDrive = new PIDDrive(); 
		//pidTurn = new PIDTurn(); 
		
		
		//driveChooser = new SendableChooser<>();
		// Add objects to "driveChooser" sendablechooser on shuffleboard/smartdashboard
		//driveChooser.addDefault("Tank Drive", new TankDrive());
		//driveChooser.addObject("Arcade Drive", new ArcadeDrive());
		//driveChooser.addObject("My Auto", new MyAutoCommand());
		//driveChooser.addObject("My Auto", new MyAutoCommand());
		//driveChooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Drive mode", driveChooser);
		
		ourSide = new SendableChooser<>();
		ourSide.addDefault("Left", new OurSide(OurSideChoice.Left));
		ourSide.addObject("Middle", new OurSide(OurSideChoice.Middle));
		ourSide.addObject("Right", new OurSide(OurSideChoice.Right));
		SmartDashboard.putData("Our Side", ourSide);
		
		primaryObjective = new SendableChooser<>();
		primaryObjective.addDefault("AutoLine", new PrimaryObjective(PrimaryObjectiveChoice.Autoline));
		primaryObjective.addObject("Scale", new PrimaryObjective(PrimaryObjectiveChoice.Scale));
		primaryObjective.addObject("Switch", new PrimaryObjective(PrimaryObjectiveChoice.Switch));
		SmartDashboard.putData("Primary Objective", primaryObjective);
		
		enableSecondary = new SendableChooser<>();
		enableSecondary.addDefault("No", new EnableSecondary(EnableSecondaryChoice.No));
		enableSecondary.addObject("Yes", new EnableSecondary(EnableSecondaryChoice.Yes));
		SmartDashboard.putData("Enable Secondary Objective?", enableSecondary);
		
		crossMiddle = new SendableChooser<>();
		crossMiddle.addDefault("Yes", new CrossMiddle(CrossMiddleChoice.Yes));
		crossMiddle.addObject("No", new CrossMiddle(CrossMiddleChoice.No));
		SmartDashboard.putData("Cross Middle?", crossMiddle);
		

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
		
//		OurSide os = (OurSide) ourSide.getSelected();
//		PrimaryObjective po = (PrimaryObjective) primaryObjective.getSelected();
//		CrossMiddle cm = (CrossMiddle) crossMiddle.getSelected();
//		EnableSecondary es = (EnableSecondary) enableSecondary.getSelected();
//		autonomousFlowchart = new FlowChartChooser(os, po, cm, es);

		//Robot.pidDrive.disable();
		//Robot.pidTurn.disable();

		//autonomousCommand = chooser.getSelected(); Change this when we get auto code

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)

//		//if (autonomousFlowchart != null)
//			//autonomousFlowchart.start();

		//PIDTurnCommand test = new PIDTurnCommand(90);
		//test.start();
		
		//RobotMap.encoderLeft.reset();
		//RobotMap.encoderRight.reset();

		DriveAndStop testForward = new DriveAndStop();
		testForward.start();
		
		 
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left  Encoder", RobotMap.encoderLeft.getDistance());
		SmartDashboard.putNumber("NavX Angle", RobotMap.navx.getAngle());
		SmartDashboard.putNumber("Left Motor Speed", RobotMap.encoderLeft.getRate());
		//SmartDashboard.putNumber("FlipEncoder", RobotMap.FlipEncoder.getDistance());
	}

	@Override
	public void teleopInit() {
		
		/** This makes sure that the autonomous stops running when teleop starts running. 
		 * If you want the autonomous to continue until interrupted by another command, remove this line or comment it out.
		 */
		if (autonomousFlowchart != null)
			autonomousFlowchart.cancel();
		driveTrain = new DriveTrain();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// Putting PDP output onto smartdashboard/shuffleboard
		Scheduler.getInstance().run();
		//RobotMap.compressor.start();

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("PDP0", RobotMap.pdp.getCurrent(0));
		SmartDashboard.putNumber("PDP1", RobotMap.pdp.getCurrent(1));
		SmartDashboard.putNumber("PDP2", RobotMap.pdp.getCurrent(2));
		SmartDashboard.putNumber("PDP5", RobotMap.pdp.getCurrent(5));
		SmartDashboard.putNumber("PDP6", RobotMap.pdp.getCurrent(6));
		SmartDashboard.putNumber("PDP7", RobotMap.pdp.getCurrent(7));
	}
}
