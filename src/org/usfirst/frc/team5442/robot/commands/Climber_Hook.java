package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climber_Hook extends Command {
	
	double speed;
	
	public Climber_Hook(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		Robot.climber.moveHook(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.climber.moveHook(0);
	}
	
	@Override
	protected void interrupted() {
		Robot.climber.moveHook(0);
	}
}
