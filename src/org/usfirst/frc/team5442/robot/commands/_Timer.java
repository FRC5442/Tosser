package org.usfirst.frc.team5442.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class _Timer extends Command {
	private double m_time;
	Timer tim = new Timer();
	
	public _Timer(double time) {
		m_time = time;
	}
	
	@Override
	protected void initialize() {
		tim.reset();
		tim.start();
	}
	
	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return tim.get() > m_time;
	}
	
	protected void end() {
		tim.stop();
	}
	

}
