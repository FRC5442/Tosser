package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class PrimaryObjective extends Command {
	private PrimaryObjectiveChoice _choice;

	public boolean set_choice(PrimaryObjectiveChoice _choice) {
		boolean value_changed = false;
		if (this._choice != _choice) {
			value_changed = true;
			this._choice = _choice;
		}
		return value_changed;
	}

	public PrimaryObjectiveChoice get_choice() {
		return _choice;
	}

	public PrimaryObjective() {
		_choice = PrimaryObjectiveChoice.Undefined;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}