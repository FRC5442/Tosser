package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSCL extends CommandGroup{

	public LeftSCL() {
		// TODO Auto-generated constructor stub
		addSequential(new PIDDriveCommand(10, 0.7, 1));
		addSequential(new PIDTurnCommand(-15));
		addSequential(new PIDDriveCommand(25, 0.7, 1));
		addSequential(new PIDTurnCommand(15));
		addSequential(new PIDDriveCommand(300, 0.8, 1));
		addSequential(new PIDTurnCommand(90));
		addSequential(new Reload());
		addSequential(new FlipAuto(1, .75));
		addSequential(new Shoot());
	}

}
