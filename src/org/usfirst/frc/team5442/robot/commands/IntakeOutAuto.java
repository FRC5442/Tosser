package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeOutAuto extends Command {
	
	double speed, time;
	Timer tim = new Timer();
	
	public IntakeOutAuto(double speed, double time) {
		this.speed = Math.abs(speed);
		this.time = time;
		
	}
	
	@Override
	protected void initialize() {
		tim.start();
		Robot.intake.doIntake(speed, false);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return tim.get() >= time;
	}
	
	@Override
	protected void end() {
		Robot.intake.doIntake(0, false);
	}

}
