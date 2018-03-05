package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDdriveCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAndStop extends CommandGroup {
	public DriveAndStop() {
		double distance = 68.18;
		double stop = 10;
		addSequential(new PIDdriveCommand(distance, 0.50, 1));
		addSequential(new Stop(-.35));
		//addSequential(new PIDdriveCommand(distance/3, -0.35, 1));
	}

}
