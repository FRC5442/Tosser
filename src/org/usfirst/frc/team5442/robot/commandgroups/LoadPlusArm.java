package org.usfirst.frc.team5442.robot.commandgroups;

import org.usfirst.frc.team5442.robot.commands.ArmingCatapult;
import org.usfirst.frc.team5442.robot.commands.LoadingCatapult;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LoadPlusArm extends CommandGroup {

	public LoadPlusArm() {
		addSequential(new LoadingCatapult(-1));
		addSequential(new ArmingCatapult(1));
	}

}
