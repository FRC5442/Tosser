package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLineOnly extends CommandGroup{

	public AutoLineOnly() {
		//untested
		//addSequential(new StraightDrive(10, .35, 1));
		addSequential(new PIDDriveCommand(120, .7, 1));
	}

}
