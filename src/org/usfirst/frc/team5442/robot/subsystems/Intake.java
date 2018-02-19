package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	double scaleValue = .8;
	public Intake() {
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void doFlip(double speed) {
		RobotMap.flipper.set(1*speed);
	}
	
	public void doIntake(double intake_speed, boolean spin) {
		double flipDirection;
		if (spin == true) {
			flipDirection = -1;
		}
		else {
			flipDirection = 1;
		}
		RobotMap.leftIntake.set(-1*scaleValue*intake_speed);
		RobotMap.rightIntake.set(flipDirection*scaleValue*intake_speed);
	}
}
