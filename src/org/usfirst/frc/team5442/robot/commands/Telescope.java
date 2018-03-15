package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Telescope extends Command {
	
	double speed;
	
	public Telescope(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		Robot.climber.moveTelescope(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.climber.moveTelescope(0);
	}

	@Override
	protected void interrupted() {
		Robot.climber.moveTelescope(0);
	}
	

}
