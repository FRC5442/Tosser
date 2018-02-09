package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class CrossMiddle extends Command{
	private CrossMiddleChoice _choice;
	
	public CrossMiddleChoice get_choice() {
		return _choice;
	}
	
	public CrossMiddle(String choice) {
		switch(choice.toLowerCase()) {
		case "Yes":
			_choice = CrossMiddleChoice.Yes;
			break;
		case "No":
			_choice = CrossMiddleChoice.No;
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
