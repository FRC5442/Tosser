package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.subsystems.Catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wind extends Command {
	
	protected void intialize() {
			RobotMap.winchCylinder.set(true);
			Timer.delay(.5);
	}
	protected void execute() {
		Catapult.wind(.8);
	}
	protected boolean isFinished() {
		return !RobotMap.windSwitch.get();
	}
	protected void end() {
		RobotMap.winchCylinder.set(false);
	}

}
