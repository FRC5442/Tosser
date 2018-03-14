package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FlipAuto extends Command {

	Timer tim = new Timer();
	private double speed, time;
	public FlipAuto(double speed, double time) {
		this.speed = speed;
		this.time = time;
	}
	
	@Override
	protected void initialize() {
		tim.start();
	}
	@Override
	protected void execute() {
		Robot.intake.doFlip(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return tim.get() >= time;
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
