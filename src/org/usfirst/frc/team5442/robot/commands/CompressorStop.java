package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.commandgroups.Reload;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CompressorStop extends Command{

	public CompressorStop() {

	}

	protected void intialize() {
		if(RobotMap.compressor.enabled()) {
			RobotMap.compressor.stop();
			Reload.setRememberComp(true);
			Timer.delay(.2);
		}
	}
	@Override
	protected boolean isFinished() {
		return true;
	}

}
