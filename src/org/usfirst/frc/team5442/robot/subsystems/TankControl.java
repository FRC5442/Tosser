package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TankControl extends Subsystem{

	
	public static DifferentialDrive DriveTrain;
	
	//private static boolean switched = true;
	
	public TankControl()
	{
		//I'm a constructor...
		//DriveTrain = RobotMap.GetDriver();
	}
	
	public static void Driving1(double leftJoystick, double rightJoystick) {
		if (DriveTrain == null) DriveTrain = RobotMap.GetDriver();
		DriveTrain.tankDrive(leftJoystick, rightJoystick, true);
	}
	/// Arcade Drive vs. Tank Drive
	/*/public static void Driving2(GenericHID leftJoystick) {
		if (!switched) setDefaultCommand(new ArcadeDrive());
		if (DriveTrain == null) DriveTrain = RobotMap.GetDriver();
		DriveTrain.arcadeDrive(leftJoystick.getRawAxis(0), leftJoystick.getRawAxis(1), true);
	}
	*/
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

}
