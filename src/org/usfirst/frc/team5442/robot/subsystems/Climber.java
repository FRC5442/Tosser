package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	VictorSP hookMotor, telescopeMotor;
	
	public Climber() {
		hookMotor = RobotMap.hookMotor;
		telescopeMotor = RobotMap.telescopeMotor;
	}
	
	public void moveHook(double speed) {
		hookMotor.set(speed);
	}
	
	public void moveTelescope(double speed) {
		telescopeMotor.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
