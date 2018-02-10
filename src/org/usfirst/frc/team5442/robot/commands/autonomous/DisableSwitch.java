package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DisableSwitch extends Command{
	private DisableSwitchChoice _choice;
	
	public boolean set_choice(DisableSwitchChoice _choice) {
		boolean value_changed = false;
		if (this._choice != _choice) {
			value_changed = true;
			this._choice = _choice;
		}
		return value_changed;
	}
	
	public DisableSwitchChoice get_choice() {
		return _choice;
	}
	
	public DisableSwitch() {
		_choice = DisableSwitchChoice.undefined;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
