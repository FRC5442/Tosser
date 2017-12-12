package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{
	
	public static Spark LeftSpark1 = RobotMap.leftController1;
	public static Spark LeftSpark2 = RobotMap.leftController2;
	public static Spark RightSpark1 = RobotMap.rightController1;
	public static Spark RightSpark2 = RobotMap.rightController2;
	
	public static RobotDrive DriveTrain = RobotMap.driveTrain;
	
	public static void RobotDrive(double left, double right) {
		DriveTrain.tankDrive(left, right);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TankDrive());
	}

}
