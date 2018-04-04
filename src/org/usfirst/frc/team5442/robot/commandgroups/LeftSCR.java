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

public class LeftSCR extends CommandGroup {
	
	public LeftSCR() {
		addSequential(new PIDDriveCommand(264, 0.5)); // Forward to in between switch and scale
		addSequential(new Stop(-0.20));
		addSequential(new PIDTurnCommand(90));   	 // Turn R
		addSequential(new PIDDriveCommand(230, 0.5)); // Forward to in line with scale
		addSequential(new Stop(-0.20));
		addSequential(new PIDTurnCommand(-90));		 // Turn L
		addSequential(new PIDDriveCommand(72, 0.5)); // Forward to null zone
		addSequential(new Stop(-0.2));
		addSequential(new PIDTurnCommand(-90));		 // Turn L
		addSequential(new PIDDriveCommand(-20, 0.5)); // Reverse to wall
		addSequential(new CompressorStop());
		addSequential(new Reload());
		addSequential(new PincerToggle());
		addSequential(new _Timer(.25));
		addSequential(new FlipAuto(.5,1));
		addSequential(new Shoot());
	}

}
