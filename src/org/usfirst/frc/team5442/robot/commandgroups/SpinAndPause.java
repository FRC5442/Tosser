package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.SpinCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpinAndPause extends CommandGroup{

	public SpinAndPause() {
		addSequential(new SpinCube(.4, -.70));
		addSequential(new SpinCube(.3, 0));
		addSequential(new SpinCube(.4, -.70));
		addSequential(new SpinCube(.3, 0));
		addSequential(new SpinCube(.4, -.70));
		addSequential(new SpinCube(.3, 0));
		addSequential(new SpinCube(.4, -.70));
		addSequential(new SpinCube(.3, 0));
		addSequential(new SpinCube(.4, -.70));
		
	}
}
