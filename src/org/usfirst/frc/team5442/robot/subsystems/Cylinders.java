package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Cylinders extends Subsystem {
	
	private Solenoid latchCylinder, winchCylinder;
	
	public Cylinders() {
		latchCylinder = RobotMap.latchCylinder;
		winchCylinder = RobotMap.winchCylinder;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void setLatchCylinder(boolean set) {
		latchCylinder.set(set);
	}
	
	public void setWinchCylinder(boolean set) {
		winchCylinder.set(set);
	}

}
