package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Catapult extends Subsystem {
	
	private VictorSP winchMotor;
	
	public Catapult() {
		winchMotor = RobotMap.winchMotor;
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void launch(double speed) {
		winchMotor.set(speed);
	}
}
