package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CompressorToggle extends Command {

	public CompressorToggle() {
	}

	protected void initialize () {
		if (RobotMap.compressor.enabled()) {
			RobotMap.compressor.stop();
		}
		else {
			RobotMap.compressor.start();
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
