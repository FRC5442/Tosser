package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAndStop extends CommandGroup {
	public DriveAndStop() {
		double distance = 41.75;
		addSequential(new PIDDriveCommand(distance, 0.50, 1));
		//addSequential(new Stop(-.30));
		addSequential(new PIDTurnCommand(90));
		
		//addSequential(new PIDdriveCommand(distance/3, -0.35, 1));
	}

}
