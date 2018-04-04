package org.usfirst.frc.team5442.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class _Timer extends Command {
	private double m_time;
	
	public _Timer(double time) {
		m_time = time;
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		Timer.delay(m_time);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
