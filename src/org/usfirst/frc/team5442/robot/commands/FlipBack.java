package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FlipBack extends Command {

	private double speed;

	public FlipBack(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		Robot.intake.doFlip(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return false/**RobotMap.backFlipStop.get()**/;
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
