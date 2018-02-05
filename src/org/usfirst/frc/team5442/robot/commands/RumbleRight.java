package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

public class RumbleRight extends Command {
	
	protected void initialize() {
		OI.setRumbleRight(.5);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		OI.setRumbleRight(0);
	}

	protected void interrupted() {
		OI.setRumbleRight(0);
	}

}
