package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PincerIn extends Command{

	public PincerIn() {
	}

	@Override
	protected void initialize() {
		Robot.pneumatics.pincing(DoubleSolenoid.Value.kForward);
		
	}
		
		
	
	@Override
	protected boolean isFinished() {

		return true;
		}

}
