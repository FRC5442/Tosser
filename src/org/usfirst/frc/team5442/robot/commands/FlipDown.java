package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FlipDown extends Command {

	//private double speed;

	public FlipDown() {
	}
	
	@Override
	protected void execute() {
		Robot.intake.doFlip(-OI.Controller2.getRawAxis(1));
	}
	
	@Override
	protected boolean isFinished() {
		return RobotMap.frontFlipStop.get();
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
