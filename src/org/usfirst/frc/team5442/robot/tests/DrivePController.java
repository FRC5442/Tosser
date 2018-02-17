package org.usfirst.frc.team5442.robot.tests;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DrivePController extends Command{

	private double Kp = .16;
	double initialAngle, speed, distance;
	
	public DrivePController(double speed, double distance) {
		this.speed = speed;
		this.distance = distance;
	}

	protected void initialize() {
		RobotMap.leftEncoder.reset();
		initialAngle = RobotMap.navx.getAngle();
	}
	
	protected void execute() {
		RobotMap.GetDriver().arcadeDrive(speed, 
				-(RobotMap.navx.getAngle()-initialAngle)*Kp);
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.leftEncoder.getDistance()) > distance );
	}

}