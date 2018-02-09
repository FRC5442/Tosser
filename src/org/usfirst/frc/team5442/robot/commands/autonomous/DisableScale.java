package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DisableScale extends Command{
	private DisableScaleChoice _choice;
	
	public DisableScaleChoice get_choice() {
		return _choice;
	}
	
	public DisableScale(String choice) {
		switch(choice.toLowerCase()) {
		case "Yes":
			_choice = DisableScaleChoice.Yes;
			break;
		case "No":
			_choice = DisableScaleChoice.No;
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
