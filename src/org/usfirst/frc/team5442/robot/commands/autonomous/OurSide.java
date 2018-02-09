package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class OurSide  extends Command{
	private OurSideChoice _choice;
	
	public OurSideChoice get_choice() {
		return _choice;
	}
	
	public OurSide(String choice) {
		switch(choice.toLowerCase()) {
		case "Left":
			_choice = OurSideChoice.Left;
			break;
		case "Middle":
			_choice = OurSideChoice.Middle;
			break;
		case "Right":
			_choice = OurSideChoice.Right;
			break;
		}
	}
	
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
