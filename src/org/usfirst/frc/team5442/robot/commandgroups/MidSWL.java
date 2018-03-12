package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidSWL extends CommandGroup{

	public MidSWL() {
		addSequential(new PIDDriveCommand(10, 0.50, 1));
		//addSequential(new Stop(-.20));
		addSequential(new PIDTurnCommand(-38));
		addSequential(new PIDDriveCommand(90, 0.50, 1));
		//addSequential(new Stop(-.20));
		addSequential(new PIDTurnCommand(38));
		addSequential(new PIDDriveCommand(24, 0.50, 1)); //check this distance
		//addSequential(new Stop(-.20));
		addSequential(new FlipAuto(1, .75));
		addSequential(new IntakeOutAuto(.70, 2));
	}

}
