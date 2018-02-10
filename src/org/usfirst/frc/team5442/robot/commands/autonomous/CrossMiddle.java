package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class CrossMiddle extends Command{
	private CrossMiddleChoice _choice;
	
	public boolean set_choice(CrossMiddleChoice _choice) {
		boolean value_changed = false;
		if (this._choice != _choice) {
			value_changed = true;
			this._choice = _choice;
		}
		return value_changed;
	}
	
	public CrossMiddleChoice get_choice() {
		return _choice;
	}
	
	public CrossMiddle() {
		_choice = CrossMiddleChoice.undefined;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
