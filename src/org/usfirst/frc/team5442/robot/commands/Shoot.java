package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command{
	
	protected void initialize() {
		//RobotMap.latchCylinder.set(DoubleSolenoid.Value.kForward);
		RobotMap.latchCylinder.set(DoubleSolenoid.Value.kReverse);
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		//RobotMap.latchCylinder.set(DoubleSolenoid.Value.kReverse);
		RobotMap.latchCylinder.set(DoubleSolenoid.Value.kForward);
	}
	protected void interrupted() {
		//RobotMap.latchCylinder.set(DoubleSolenoid.Value.kReverse);
		RobotMap.latchCylinder.set(DoubleSolenoid.Value.kForward);
	}

}
