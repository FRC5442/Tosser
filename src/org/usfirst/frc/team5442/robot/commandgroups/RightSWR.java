package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSWR extends CommandGroup {

	public RightSWR() {
		//
		addSequential(new PIDDriveCommand(145, -.5));
		addSequential(new Stop(-.25));
		addSequential(new PIDTurnCommand(-90));
		addSequential(new PIDDriveCommand(18, -.5));
		addSequential(new IntakeOutAuto(.7, 2));
	}

}
