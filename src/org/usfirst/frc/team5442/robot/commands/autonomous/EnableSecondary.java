package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class EnableSecondary extends Command{
	private EnableSecondaryChoice _choice;
	
	public EnableSecondaryChoice get_choice() {
		return _choice;
	}
	
	public EnableSecondary(EnableSecondaryChoice choice) {
		_choice = choice; 
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
