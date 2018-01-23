package org.usfirst.frc.team5442.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command {
	
	double speed;
	
	public IntakeOut(double speed) {
		this.speed = -Math.abs(speed);
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
