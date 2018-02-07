package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	public Intake() {
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void doFlip(double speed) {
		RobotMap.flipper.set(1*speed);
	}
	
	public void doIntake(double intake_speed) {
		RobotMap.leftIntake.set(.8*intake_speed);
		RobotMap.rightIntake.set(.8*intake_speed);
	}
}
