package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmLatch;
import org.usfirst.frc.team5442.robot.commands.Shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Marksman extends CommandGroup {
	public Marksman() {
		addSequential(new ArmLatch(1));
		addSequential(new Shoot());
	}

}
