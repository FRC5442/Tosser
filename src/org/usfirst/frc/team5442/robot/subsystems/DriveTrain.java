package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem{
	private static boolean _normalHeading;
	
	public static DifferentialDrive DriveTrain;
	
	//private static boolean switched = true;
	
	public DriveTrain()
	{
		//I'm a constructor...
		//DriveTrain = RobotMap.GetDriver();
		_normalHeading = true;
	}
	
	public static void Driving(double leftJoystick, double rightJoystick) {
		if (DriveTrain == null) DriveTrain = RobotMap.GetDriver();
		if (_normalHeading)
			DriveTrain.tankDrive(leftJoystick, rightJoystick);
		else
			DriveTrain.tankDrive(-1*rightJoystick, -1*leftJoystick);
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

	public void SwitchHeading() {
		_normalHeading = !_normalHeading;
	}
}
