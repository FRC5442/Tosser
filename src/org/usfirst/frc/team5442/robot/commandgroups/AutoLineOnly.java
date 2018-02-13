package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.StraightDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLineOnly extends CommandGroup{

	public AutoLineOnly() {
		//untested
		addSequential(new StraightDrive(10, .75, 1));
	}

}
