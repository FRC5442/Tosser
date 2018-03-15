package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PincerToggle extends Command{
	@Override
	protected void initialize() {
		if (RobotMap.pincer.get() == DoubleSolenoid.Value.kReverse) {
			Robot.pneumatics.pincing(DoubleSolenoid.Value.kForward);
		}
		else {
			Robot.pneumatics.pincing(DoubleSolenoid.Value.kReverse);
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
