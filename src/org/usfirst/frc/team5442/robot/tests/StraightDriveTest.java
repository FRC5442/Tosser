package org.usfirst.frc.team5442.robot.tests;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightDriveTest extends CommandGroup {

	public StraightDriveTest() {
		addSequential(new AccelerationDriving(0.005, -0.75, 100));
	}

}
