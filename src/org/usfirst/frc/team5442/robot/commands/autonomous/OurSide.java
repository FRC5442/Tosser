package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class OurSide  extends Command{
	private OurSideChoice _choice;
	
	public OurSideChoice get_choice() {
		return _choice;
	}
	
	public OurSide(OurSideChoice choice) {
		_choice = choice;
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
