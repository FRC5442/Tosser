package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command {
	
	private double speed;
	
	public IntakeIn(double speed) {
		this.speed = -Math.abs(speed);
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
