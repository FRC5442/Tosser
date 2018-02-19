package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FlipToAngle extends Command{

	private double speed;
	public FlipToAngle(double speed) {
		this.speed = speed;
	}

	protected void execute() {
		if(RobotMap.flipEncoder.getDistance() < 15) {
			Robot.intake.doFlip(speed);
		}
		else if (RobotMap.flipEncoder.getDistance() > 25) {
			Robot.intake.doFlip(-speed);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
