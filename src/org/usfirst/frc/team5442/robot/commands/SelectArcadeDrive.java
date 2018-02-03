package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SelectArcadeDrive extends Command {
	
	@Override
	protected void initialize() {
		Robot.StartArcadeDriving();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
