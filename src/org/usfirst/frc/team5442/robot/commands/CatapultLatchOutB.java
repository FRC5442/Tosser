package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class CatapultLatchOutB extends Command{

	public CatapultLatchOutB() {	
		
	}

	@Override
	protected void execute() {
		Robot.pneumatics.shooterLatching(DoubleSolenoid.Value.kReverse);
	}
	
	@Override
	protected boolean isFinished() {
		return RobotMap.shooterLatch.get() == DoubleSolenoid.Value.kReverse;
	}

}
