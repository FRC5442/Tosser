package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.subsystems.ArcadeControl;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command{

	public ArcadeDrive(){
		requires(Robot.arcadeControl);
	}
	
	@Override
	protected void execute(){
		ArcadeControl.Driving2(OI.xboxController1);
		//DriveTrain2.Driving2(OI.xboxController1.getRawAxis(1), OI.xboxController1.getRawAxis(5));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
