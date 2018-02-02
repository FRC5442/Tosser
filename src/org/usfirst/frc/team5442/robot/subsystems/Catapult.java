package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Catapult extends Subsystem {
	
	private static VictorSP winchMotor;
	
	public Catapult() {
		winchMotor = RobotMap.spinRodMotor;
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public static void wind(double speed) {
		winchMotor.set(speed);
	}
}
