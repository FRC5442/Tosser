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
<<<<<<< .merge_file_a08124
		return !RobotMap.latchSwitch2.get();
=======
		return !RobotMap.catapultSwitch.get();
>>>>>>> .merge_file_a05124
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
