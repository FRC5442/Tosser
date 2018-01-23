package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FlipForward extends Command {

	private double speed;

	public FlipForward(double speed) {
		this.speed = Math.abs(speed);
	}
	
	@Override
	protected void initialize() {
		Robot.intake.doFlip(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return RobotMap.frontFlipStop.get();
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
