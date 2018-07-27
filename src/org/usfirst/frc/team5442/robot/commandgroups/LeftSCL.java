package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.CompressorStop;
import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PincerToggle;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.Stop;
import org.usfirst.frc.team5442.robot.commands._Timer;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSCL extends CommandGroup{

	public LeftSCL() {
		//mostly done, check distances, 
		
		addSequential(new PIDDriveCommand(307.5, -0.5));
		addSequential(new Stop(-.15));
		addSequential(new PIDTurnCommand(-90));
		addSequential(new PIDDriveCommand(3, -.75));
		addSequential(new CompressorStop());
		addSequential(new Reload());
		addSequential(new PincerToggle());
		addSequential(new _Timer(.25));
		addSequential(new FlipAuto(-.35, .75));
		addSequential(new Shoot());
	}

}
