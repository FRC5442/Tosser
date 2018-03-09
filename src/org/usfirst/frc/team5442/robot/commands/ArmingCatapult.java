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
		
		RobotMap.catapultMotor.set(speed);
	}
	
	@Override
	protected boolean isFinished() {
		return RobotMap.catapultSwitch.get();
	}
	
	@Override
	protected void end() {
		RobotMap.catapultMotor.set(0);
	}
	
	@Override
	protected void interrupted() {
		RobotMap.catapultMotor.set(0);
	}
	
}
