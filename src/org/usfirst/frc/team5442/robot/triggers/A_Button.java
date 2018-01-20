package org.usfirst.frc.team5442.robot.triggers;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.commands.HighShift;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class A_Button extends Trigger{

	public A_Button() {
		whenActive(new HighShift());
	}
	
	@Override
	public boolean get() {
		SmartDashboard.putNumber("Counter", 1);
		return OI.xboxController.getAButtonPressed();
	}
	

	

}
