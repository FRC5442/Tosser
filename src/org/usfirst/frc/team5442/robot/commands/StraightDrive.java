package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class StraightDrive extends Command{

	double m_distance;
	double m_speed;
	int m_direction;
	
	public StraightDrive(
			double distance, double speed, int direction) {
		m_distance = distance;
		m_speed = speed;
		m_direction = direction;
	}
	
	protected void initialize() {
		Robot.pidDrive.setDirection(m_direction);
		Robot.pidDrive.setDrive_speed(m_speed);
		Robot.pidDrive.enable();
		Robot.pidDrive.setSetpointRelative(0);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Math.abs(RobotMap.encoderLeft.getDistance()) > m_distance);
	}

	protected void end() {
		Robot.pidDrive.disable();
		RobotMap.driveTrain.curvatureDrive(0, 0, false);
	}
}
