package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Stop extends Command{

	
	Timer tim = new Timer();
	private double speed;
	public Stop(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		tim.start();
	}
	
	@Override
	protected void execute() {
		RobotMap.driveTrain.curvatureDrive(speed, 0, false);
	}
	
	@Override
	protected boolean isFinished() {
		return Math.abs(RobotMap.encoderLeft.getRate()) < 1.5 || tim.get() >= 1;

	}

	@Override
	protected void end() {
		RobotMap.driveTrain.arcadeDrive(0, 0);
	}
}
