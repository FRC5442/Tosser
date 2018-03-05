package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDdriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine_CloseSwitch extends CommandGroup {

	public AutoLine_CloseSwitch() {
		addSequential(new PIDdriveCommand(10, 0.75, 0));
		addSequential(new PIDTurnCommand(90));
		addSequential(new PIDdriveCommand(3, 0.75, 0));
	}

}
