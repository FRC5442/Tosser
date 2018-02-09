package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class PrimaryObjective extends Command {
	private PrimaryObjectiveChoice _choice;

	public PrimaryObjectiveChoice get_choice() {
		return _choice;
	}

	public PrimaryObjective(String choice) {
		switch(choice.toLowerCase()) {
		case "switch":
			_choice = PrimaryObjectiveChoice.Switch;
			break;
		case "autoline":
			_choice = PrimaryObjectiveChoice.Autoline;
			break;
		case "scale":
			_choice = PrimaryObjectiveChoice.Scale;
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}