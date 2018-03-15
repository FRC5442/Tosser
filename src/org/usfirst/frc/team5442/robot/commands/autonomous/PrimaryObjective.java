package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class PrimaryObjective extends Command {
	private PrimaryObjectiveChoice _choice;

	public PrimaryObjectiveChoice get_choice() {
		return _choice;
	}

	public PrimaryObjective(PrimaryObjectiveChoice choice) {
		_choice = choice;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}