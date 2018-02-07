package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Cylinders extends Subsystem {
	
	private DoubleSolenoid latchCylinder;
	
	public Cylinders() {
		latchCylinder = RobotMap.latchCylinder;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void setLatchCylinder(Value set) {
		latchCylinder.set(set);
	}


}
