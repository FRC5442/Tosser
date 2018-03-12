package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidALR extends CommandGroup {

	public MidALR() {
		addSequential(new PIDDriveCommand(120, 0.50, 1));
		addSequential(new PIDTurnCommand(38));
		addSequential(new PIDDriveCommand(90, 0.50, 1));
		addSequential(new PIDTurnCommand(-38));
		addSequential(new PIDDriveCommand(24, 0.50, 1)); //check this distance
		addSequential(new FlipAuto(1, .75));
		addSequential(new IntakeOutAuto(.70, 2));
	}

}
