package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmingCatapult;
import org.usfirst.frc.team5442.robot.commands.CatapultLatch;
import org.usfirst.frc.team5442.robot.commands.CompressorStart;
import org.usfirst.frc.team5442.robot.commands.CompressorStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Reload extends CommandGroup{

	private static boolean _rememberComp;
	
	public static boolean isRememberComp() {
		return _rememberComp;
	}

	public static void setRememberComp(boolean rememberComp) {
		_rememberComp = rememberComp;
	}

	public Reload() {
		addSequential(new CompressorStop());
		addSequential(new CatapultLatch());
		addSequential(new ArmingCatapult(1));
		addSequential(new CatapultLatch());
		addSequential(new CompressorStart());
		
	}

}


