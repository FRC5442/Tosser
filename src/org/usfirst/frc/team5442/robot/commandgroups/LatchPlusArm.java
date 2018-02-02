package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmLatch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LatchPlusArm extends CommandGroup {

	public LatchPlusArm() {
		addSequential(new ArmLatch(0.5));
		addSequential(new ArmLatch(-0.5));
	}

}
