package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command{

	public ArcadeDrive(){
		requires(Robot.driveTrain);
	}
	
	protected void execute(){
		//DriveTrain.Driving2(OI.xboxController);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
