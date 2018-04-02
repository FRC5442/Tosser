package org.usfirst.frc.team5442.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SpinAndPause extends CommandGroup{

	public SpinAndPause() {
		// TODO Auto-generated constructor stub
		addSequential(new SpinCube(.4, -.7));
		addSequential(new SpinCube(.35, 0));
		addSequential(new SpinCube(.4, -.7));
		addSequential(new SpinCube(.35, 0));
		addSequential(new SpinCube(.4, -.7));
	}

}
