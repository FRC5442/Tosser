package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;
import org.usfirst.frc.team5442.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class _Drive extends Command{
	private double enc_distance;
	private double m_speedL;
	private double m_speedR;
	
	public _Drive(double distance, double speedL, double speedR) {
		enc_distance = distance;
		m_speedL = speedL;
		m_speedR = speedR;
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		DriveTrain.Driving(m_speedL, m_speedR);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Math.abs(RobotMap.encoderRight.getDistance()) > enc_distance); 

		
	}
	@Override
	protected void end() {
		DriveTrain.Driving(0, 0);
		
	}

}
