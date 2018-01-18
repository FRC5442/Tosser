package org.usfirst.frc.team5442.robot.triggers;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.commands.LowShift;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class B_Button extends Trigger{

	public B_Button () {
		whenActive(new LowShift());
	}
	
	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return OI.xboxController.getBButtonPressed();
	}

}
