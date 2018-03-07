package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine_FarScale extends CommandGroup {

	public AutoLine_FarScale() {
		addSequential(new PIDDriveCommand(33.8, 0.75, 0));
		addSequential(new PIDTurnCommand(90));
		addSequential(new PIDDriveCommand(33.8, 0.75, 0));
		addSequential(new PIDTurnCommand(-90));
		addSequential(new PIDDriveCommand(33.8, 0.75, 0));
	}

}
