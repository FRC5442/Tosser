package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.CompressorStop;
import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PincerToggle;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.Stop;
import org.usfirst.frc.team5442.robot.commands._Timer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightSCR extends CommandGroup{

	public RightSCR() {
		//Mechanisms work, distances not good yet
		
		//addSequential(new PIDDriveCommand(10, 0.7, 1));
		//addSequential(new PIDTurnCommand());
		//addSequential(new PIDDriveCommand(25, 0.7, 1));
		//addSequential(new PIDTurnCommand(-15));
	
		addSequential(new PIDDriveCommand(324, 0.5));
		addSequential(new Stop(-.20));
		addSequential(new PIDTurnCommand(-90));
		addSequential(new PIDDriveCommand(-25, .85));
		addSequential(new CompressorStop());
		addSequential(new Reload());
		addSequential(new PincerToggle());
		addSequential(new _Timer(.25));
		addSequential(new FlipAuto(.25, 1));
		addSequential(new Shoot());
		
	}

}
