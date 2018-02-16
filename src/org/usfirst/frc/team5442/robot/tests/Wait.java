package org.usfirst.frc.team5442.robot.tests;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{
	
	private double time;
	Timer m_Timer = new Timer();
	
	public Wait(double time) {
		this.time = time; 
	}

	protected void intialize() {
		m_Timer.reset();
		m_Timer.start();
	}
	
	@Override
	protected boolean isFinished() {
		return m_Timer.get() >= time;
	}

	protected void end() {
		m_Timer.stop();
	}
}
