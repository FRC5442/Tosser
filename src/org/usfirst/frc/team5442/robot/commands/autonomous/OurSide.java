package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class OurSide  extends Command{
	private OurSideChoice _choice;
	
	public boolean set_choice(OurSideChoice _choice) {
		boolean value_changed = false;
		if (this._choice != _choice) {
			value_changed = true;
			this._choice = _choice;
		}
		return value_changed;
	}

	public OurSideChoice get_choice() {
		return _choice;
	}
	
	public OurSide() {
		_choice = OurSideChoice.Undefined;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
