package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commandgroups.Reload;

import edu.wpi.first.wpilibj.command.Command;

public class CompressorStart extends Command{

	public CompressorStart() {

	}

	protected void intialize() {
		if(Reload.isRememberComp()) {
			RobotMap.compressor.start();
			Reload.setRememberComp(false);
		}
	}
	@Override
	protected boolean isFinished() {
		return true;
	}

}
