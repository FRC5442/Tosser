package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	
	public Pneumatics() {
		RobotMap.compressor.start();
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void gearShift(Value position) {
		RobotMap.gearShiftLeft.set(position);
		RobotMap.gearShiftRight.set(position);
	}

}
