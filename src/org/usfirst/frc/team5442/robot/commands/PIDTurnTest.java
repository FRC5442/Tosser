package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PIDTurnTest extends Command {
	
	double setpoint;

	public PIDTurnTest(double setpoint) {
		this.setpoint = setpoint;
	}
	
	@Override
	protected void execute() {
		double speed = setpoint - RobotMap.navx.getAngle() / 100;
		
		if (speed > 1) speed = 1;
		else if (speed < -1) speed = -1;
		
		if (Math.abs(setpoint - RobotMap.navx.getAngle()) <= 360 - Math.abs(setpoint - RobotMap.navx.getAngle())) {
			RobotMap.driveTrain.tankDrive(-speed, speed);
		}
		else {
			RobotMap.driveTrain.tankDrive(speed, -speed);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return setpoint - RobotMap.navx.getAngle() == 0;
	}
	
	@Override
	protected void end() {
		RobotMap.driveTrain.tankDrive(0, 0);
	}

}
