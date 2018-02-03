package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class FlipStop extends Command{
	
	private double speed, distance;
	
	public FlipStop(double speed, double distance) {
		this.speed = speed;
		this.distance = distance;
	}
	
	@Override
	protected void execute() {
		Robot.intake.doFlip(speed);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(RobotMap.FlipEncoder.getDistance()) < distance;
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
