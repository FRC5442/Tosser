package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HighShift extends Command {
	
	@Override
	protected void initialize() {
		Robot.pneumatics.gearShift(false);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
