package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchHeading extends Command {
	
	@Override
	protected void initialize() {
		Robot.SwitchHeading();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
