package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command {
	
	double speed;
	
	public IntakeOut(double speed) {
		this.speed = -1*(Math.abs(speed));
		
	}
	
	@Override
	protected void initialize() {
		Robot.intake.doIntake(speed, false);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		Robot.intake.doIntake(0, false);
	}

}
