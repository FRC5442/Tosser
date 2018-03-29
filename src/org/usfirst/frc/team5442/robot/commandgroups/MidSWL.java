package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MidSWL extends CommandGroup{

	public MidSWL() {
		//Good Stuff. Works on practice bot, check on comp bot
		addSequential(new PIDDriveCommand(10, 0.50));
		addSequential(new Stop(-.15));
		addSequential(new PIDTurnCommand(-38));
		addSequential(new PIDDriveCommand(94, 0.50));//87
		addSequential(new Stop(-.15));
		addSequential(new PIDTurnCommand(38));
		addSequential(new PIDDriveCommand(20, 0.50)); //26
		addSequential(new Stop(-.15));
		addSequential(new FlipAuto(1, .75));
		addSequential(new IntakeOutAuto(.70, 2));
	}

}
