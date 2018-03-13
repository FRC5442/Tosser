package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAndStop extends CommandGroup {
	public DriveAndStop() {
		//Don't use in competition, just for testing stuff.
		double distance = 36;
		addSequential(new PIDDriveCommand(distance, 0.50));
		addSequential(new Stop(-.20));

		addSequential(new PIDTurnCommand(45));
		
		addSequential(new PIDDriveCommand(distance, 0.50));
		addSequential(new Stop(-.20));

		addSequential(new PIDTurnCommand(-45));

		addSequential(new PIDDriveCommand(distance, 0.50));
		addSequential(new Stop(-.20));
}

}

//.796x-3.57
//10, 18
//20, 28
//30, 42, 41
//40, 55.5
//50, 67.5

//70, 92