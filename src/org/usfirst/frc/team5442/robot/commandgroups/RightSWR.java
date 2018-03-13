package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSWR extends CommandGroup {

	public RightSWR() {
		//untested, don't use
		addSequential(new PIDDriveCommand(10, .5));
		addSequential(new PIDTurnCommand(-15));
		addSequential(new PIDDriveCommand(115, 0.7));
		addSequential(new PIDTurnCommand(15));
		addSequential(new PIDDriveCommand(20, .07));
		addSequential(new FlipAuto(1, .75));
		addSequential(new IntakeOutAuto(.70, 2));
	}

}
