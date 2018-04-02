package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PincerOut extends Command {
	
	public PincerOut() {
		
	}
	
	@Override
	protected void initialize(){
		Robot.pneumatics.pincing(DoubleSolenoid.Value.kReverse);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//return RobotMap.pincer.equals(DoubleSolenoid.Value.kOff);
		return true;
	}

}
