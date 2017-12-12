package org.usfirst.frc.team5442.robot.subsystems;

import java.io.Console;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
	
	private static Spark LeftSpark1 = RobotMap.leftController1;
	private static Spark LeftSpark2 = RobotMap.leftController2;
	private static Spark RightSpark1 = RobotMap.rightController1;
	private static Spark RightSpark2 = RobotMap.rightController2;
	
	public static RobotDrive DriveTrain;
	
	public DriveTrain()
	{
		//I'm a constructor...
		//DriveTrain = RobotMap.GetDriver();
	}
	
	public static void Driving(double left, double right) {
		System.out.println("left(" + left + ") right(" + right + ")");
		if (DriveTrain == null) DriveTrain = RobotMap.GetDriver();
		DriveTrain.tankDrive(left, right);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TankDrive());
	}

}
