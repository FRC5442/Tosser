package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{

	
	public Pneumatics() {
		// Starting compressor when code is called, which is at beginning on enabled mode
		RobotMap.compressor.start();
	}
	
	@Override
	protected void initDefaultCommand() {
		
		
	}
	
	public void gearShift(Value position) {
		RobotMap.gearShift.set(position);
		// This method allows the gear shifts to be set a position, either forward or reverse
	}
	public void pincing(Value pince) {
		RobotMap.pincer.set(pince);
		
	}
	public void shooterLatching(Value position) {
		RobotMap.shooterLatch.set(position);

	}
}	