package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Flip extends Command {

	//private double speed;

	public Flip() {
	}
	
	@Override
	protected void execute() {
		Robot.intake.doFlip(-OI.Controller2.getRawAxis(1));
	}
	
	@Override
	protected boolean isFinished() {
		return false;
		//return RobotMap.frontFlipStop.get() && OI.Controller2.getRawAxis(1) < 0 || RobotMap.backFlipStop.get() && OI.Controller2.getRawAxis(1) > 0;
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
