package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class FlipExecutable extends Command{

	Command up;
	Command down;
	public FlipExecutable() {
		this.up = new FlipUp();
		this.down = new FlipDown();
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if(OI.Controller2.getRawAxis(1) > 0) {
			if(down.isRunning())
				down.cancel();
			else if (!up.isRunning()) {
				up.start();
			}
		}
		else {
			if(up.isRunning()) 
				up.cancel();
			else if (!down.isRunning()) {
				down.start();				
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(down.isRunning())
			down.cancel();
		if(up.isRunning()) 
			up.cancel();
	}
	
	@Override
	protected void interrupted() {
		if(down.isRunning())
			down.cancel();
		if(up.isRunning()) 
			up.cancel();
	}
}
