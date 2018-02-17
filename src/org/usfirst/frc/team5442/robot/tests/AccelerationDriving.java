package org.usfirst.frc.team5442.robot.tests;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AccelerationDriving extends Command {
	
	private double rate, maxSpeed, distance, currentSpeed;
	
	public AccelerationDriving(double rate, double maxSpeed, double distance) {
		this.rate = rate;
		this.maxSpeed = maxSpeed;
		this.distance = distance;
	}
	
	@Override
	protected void initialize() {
		currentSpeed = .2*Math.signum(maxSpeed);
		RobotMap.leftEncoder.reset();
	}
	
	protected void execute() {
		RobotMap.GetDriver().tankDrive(currentSpeed, currentSpeed);
		
		if (distance - Math.abs(RobotMap.leftEncoder.getDistance()) < 20) {
			currentSpeed -= Math.signum(maxSpeed)*3*rate;
		}
		else if (Math.abs(currentSpeed) < Math.abs(maxSpeed)) {
			currentSpeed += Math.signum(maxSpeed)*rate;
		}
	}
	
	public void setCurrentSpeed(double speed) {
		currentSpeed = speed;
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(RobotMap.leftEncoder.getDistance()) > distance;
	}
	
	protected void end() {
		RobotMap.GetDriver().tankDrive(0, 0);
	}

}
