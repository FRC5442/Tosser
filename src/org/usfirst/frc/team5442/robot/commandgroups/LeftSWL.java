package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSWL extends CommandGroup {

	public LeftSWL() {
		addSequential(new PIDDriveCommand(10, 0.5, 1));
		addSequential(new PIDTurnCommand(15));
		addSequential(new PIDDriveCommand(115, 0.7, 1));
		addSequential(new PIDTurnCommand(-15));
		addSequential(new PIDDriveCommand(20, .07, 1));
	}

}
