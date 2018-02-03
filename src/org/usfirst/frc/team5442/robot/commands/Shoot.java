package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command{
	
	protected void initialize() {
		RobotMap.latchCylinder.set(true);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		RobotMap.latchCylinder.set(false);
	}

	protected void interrupted() {
		RobotMap.latchCylinder.set(false);
	}

}
