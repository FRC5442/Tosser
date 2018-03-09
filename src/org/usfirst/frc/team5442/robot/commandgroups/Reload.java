package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmingCatapult;
import org.usfirst.frc.team5442.robot.commands.CatapultLatch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Reload extends CommandGroup{

	public Reload() {
		addSequential(new CatapultLatch());
		addSequential(new ArmingCatapult(1));
		addSequential(new CatapultLatch());
		
	}

}


