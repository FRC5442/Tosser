package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.OI;
import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FlipUp extends Command {

	public FlipUp() {
	}
	
	@Override
	protected void execute() {
		Robot.intake.doFlip(-OI.Controller2.getRawAxis(1));
	}
	
	@Override
	protected boolean isFinished() {
<<<<<<< .merge_file_a01628
		//return RobotMap.backFlipStop.get();
		return false;
=======
		return !RobotMap.backFlipStop.get();
>>>>>>> .merge_file_a06704
	}
	
	@Override
	protected void end() {
		Robot.intake.doFlip(0);
	}

}
