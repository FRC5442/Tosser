package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SelectTankDrive extends Command {
	
	@Override
	protected void initialize() {
		Robot.StartTankDriving();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
