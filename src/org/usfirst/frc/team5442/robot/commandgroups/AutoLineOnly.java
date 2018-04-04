package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLineOnly extends CommandGroup{

	public AutoLineOnly() {
		//Tested, should be good. Right or left side only
		addSequential(new PIDDriveCommand(140, -.5));
		addSequential(new Stop(.25));
		
		
	}

}
