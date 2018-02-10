package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DisableSwitch extends Command{
	private DisableSwitchChoice _choice;
	
	public DisableSwitchChoice get_choice() {
		return _choice;
	}
	
	public DisableSwitch(DisableSwitchChoice choice) {
		_choice = choice;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
