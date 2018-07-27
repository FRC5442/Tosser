package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.FlipAuto;
import org.usfirst.frc.team5442.robot.commands.IntakeOutAuto;
import org.usfirst.frc.team5442.robot.commands.PIDDriveCommand;
import org.usfirst.frc.team5442.robot.commands.PIDTurnCommand;
import org.usfirst.frc.team5442.robot.commands.PincerOut;
import org.usfirst.frc.team5442.robot.commands.Shoot;
import org.usfirst.frc.team5442.robot.commands.Stop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftDouble extends CommandGroup{
	
	public LeftDouble() {
		// Start with cube in robot
		addSequential(new PIDDriveCommand(-1, -.8)); // Drive forward to be in line with scale
		addSequential(new Stop(0.2));
		addSequential(new PIDTurnCommand(90)); // Turn to face scale
		addSequential(new PIDDriveCommand(-1, -.8)); // Drive back to wall
		addParallel(new Reload());
		addSequential(new PincerOut());
		addSequential(new FlipAuto(0.6, 1));
		addSequential(new Shoot());
		addSequential(new PIDDriveCommand(-1, -0.8)); // Get off of the wall
		addSequential(new PIDTurnCommand(45)); // turn towards the box
		addSequential(new PIDDriveCommand(-1, -0.8)); // Drive towards next box
		addSequential(new FlipAuto(-0.6, 3)); // Flip intake down
		addSequential(new IntakeOutAuto(-1, 3)); // Intake Cube
		addSequential(new FlipAuto(.6, 3));
		addSequential(new PIDDriveCommand(-1, 0.8)); // Drive Back towards scale
		addSequential(new PIDTurnCommand(-45)); // Turn back towards scale
		addSequential(new PIDDriveCommand(-1, 0.8)); // Drive back towards wall
		addParallel(new Reload());
		addSequential(new PincerOut());
		addSequential(new FlipAuto(0.6, 1));
		addSequential(new Shoot());
		
	}

}
