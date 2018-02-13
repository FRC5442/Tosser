package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class CrossMiddle extends Command
{
	private CrossMiddleChoice _choice;
	
	public CrossMiddleChoice get_choice() {
		return _choice;
	}
	
	public CrossMiddle(CrossMiddleChoice choice) {
		_choice = choice;
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
