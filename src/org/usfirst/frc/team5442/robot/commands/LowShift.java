package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class LowShift extends Command {
	
	@Override
	protected void initialize() {
		Robot.pneumatics.gearShift(DoubleSolenoid.Value.kForward);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
