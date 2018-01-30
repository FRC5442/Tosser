package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.subsystems.Catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wind extends Command {
	
	protected void intialize() {
		}
	protected void execute() {
		RobotMap.winchCylinder.set(true);
		Timer.delay(.2);
		Catapult.wind(.8);
	}
	protected boolean isFinished() {
		return !RobotMap.windSwitch.get();
		//reversed????
	}
	protected void end() {
		Catapult.wind(0);
		Timer.delay(.15);
		RobotMap.winchCylinder.set(false);
		
	}
	
	protected void interrupted() {
		RobotMap.winchCylinder.set(false);
		Catapult.wind(0);
	}

}
