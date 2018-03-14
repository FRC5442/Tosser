package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidALL extends CommandGroup {

	public MidALL() {
		//This one should be good.
		addSequential(new PIDDriveCommand(10, 0.50));
		addSequential(new Stop(-.20));
		addSequential(new PIDTurnCommand(-38));
		addSequential(new PIDDriveCommand(90, 0.50));
		addSequential(new Stop(-.20));
		addSequential(new PIDTurnCommand(38));
		addSequential(new PIDDriveCommand(24, 0.50)); 
		addSequential(new Stop(-.20));
	}

}
