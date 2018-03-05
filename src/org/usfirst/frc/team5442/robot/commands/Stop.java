package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Stop extends Command{

	private double speed;
	public Stop(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void execute() {
		RobotMap.driveTrain.curvatureDrive(speed, 0, false);
	}
	
	@Override
	protected boolean isFinished() {
		return Math.abs(RobotMap.encoderLeft.getRate()) < .3;
	}

}
