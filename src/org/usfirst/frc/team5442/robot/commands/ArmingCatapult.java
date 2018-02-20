package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ArmingCatapult extends Command{
	
	double speed;
	
	public ArmingCatapult(double speed) {
		this.speed = speed;
	}
	@Override
	protected void execute() {
		
		RobotMap.spinRodMotor.set(speed);
	}
	
	@Override
	protected boolean isFinished() {
		//return RobotMap.latchSwitch2.get();
		return false;
	}
	
	@Override
	protected void end() {
		RobotMap.spinRodMotor.set(0);
	}
	
	@Override
	protected void interrupted() {
		RobotMap.spinRodMotor.set(0);
	}
	
}
