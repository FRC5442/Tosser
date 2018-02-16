package org.usfirst.frc.team5442.robot.tests;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnTest extends CommandGroup{

	public TurnTest() {
		//addSequential(new AccelerationDriving(.025, .5, 3));
		addSequential(new PointTurn(-90));
		//addSequential(new Wait(2));
		addSequential(new PointTurn(90));
	}

}
