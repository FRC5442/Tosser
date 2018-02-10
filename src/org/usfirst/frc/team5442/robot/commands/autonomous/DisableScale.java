package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DisableScale extends Command{
	private DisableScaleChoice _choice;
	
	public DisableScaleChoice get_choice() {
		return _choice;
	}
	
	public DisableScale(DisableScaleChoice choice) {
		_choice = choice; 
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
