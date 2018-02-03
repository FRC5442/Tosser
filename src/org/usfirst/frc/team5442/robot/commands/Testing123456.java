package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class Testing123456 extends PIDCommand{

	public Testing123456() {
		super(0.5, 0, 0);
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		if(OI.xboxController1.getRawAxis(1) - OI.xboxController1.getRawAxis(5) < 0.05) {
			setSetpointRelative(0);
			RobotMap.GetDriver().arcadeDrive(OI.xboxController1.getRawAxis(1), output);
		}
		else {
			DriveTrain.Driving((OI.xboxController1.getRawAxis(1)), (OI.xboxController1.getRawAxis(5)));
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
