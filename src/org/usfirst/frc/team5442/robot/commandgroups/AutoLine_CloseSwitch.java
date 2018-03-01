package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.StraightDrive;
import org.usfirst.frc.team5442.robot.commands.TurnToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLine_CloseSwitch extends CommandGroup {

	public AutoLine_CloseSwitch() {
		addSequential(new StraightDrive(10, 0.75, 0));
		addSequential(new TurnToAngle(0.75, 90));
		addSequential(new StraightDrive(3, 0.75, 0));
	}

}
