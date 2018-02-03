package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command{

	public TankDrive() {
		requires(Robot.driveTrain);
	}
	
	
	protected void execute() {
		//DriveTrain.Driving(OI.xboxController.getRawAxis(1), OI.xboxController.getRawAxis(5));
    	DriveTrain.Driving((OI.xboxController1.getRawAxis(1)), (OI.xboxController1.getRawAxis(5)));
		
	}
	@Override
	protected boolean isFinished() {
		return false;
	}

}
