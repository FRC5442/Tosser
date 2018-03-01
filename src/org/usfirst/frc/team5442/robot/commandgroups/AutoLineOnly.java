package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDdriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLineOnly extends CommandGroup{

	public AutoLineOnly() {
		//untested
		//addSequential(new StraightDrive(10, .35, 1));
		addSequential(new PIDdriveCommand(10, .7, 1));
	}

}
