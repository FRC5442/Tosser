package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DisableScale extends Command{
	private DisableScaleChoice _choice;
	
	public boolean set_choice(DisableScaleChoice _choice) {
		boolean value_changed = false;
		if (this._choice != _choice) {
			value_changed = true;
			this._choice = _choice;
		}
		return value_changed;
	}
	
	public DisableScaleChoice get_choice() {
		return _choice;
	}
	
	public DisableScale() {
		_choice = DisableScaleChoice.undefined; 
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
