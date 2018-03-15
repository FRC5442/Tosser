package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmingCatapult;
import org.usfirst.frc.team5442.robot.commands.CatapultLatchInB;
import org.usfirst.frc.team5442.robot.commands.CatapultLatchOutB;
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
		addSequential(new CatapultLatchInB());
		addSequential(new ArmingCatapult(1));
		addSequential(new CatapultLatchOutB());
		addSequential(new CompressorStart());
		
	}

}


