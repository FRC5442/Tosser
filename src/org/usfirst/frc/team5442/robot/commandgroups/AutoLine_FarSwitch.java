package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine_FarSwitch extends CommandGroup {

	public AutoLine_FarSwitch() {
		addSequential(new PIDDriveCommand(10, 0.75, 0));
		addSequential(new PIDTurnCommand(90));
		addSequential(new PIDDriveCommand(10, 0.75, 0));
		addSequential(new PIDTurnCommand(90));
		addSequential(new PIDDriveCommand(1, 0.75, 0));
	}

}
