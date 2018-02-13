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
		m_direction = direction; // positive or negative 1
	}
	
	protected void initialize() {
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
		Robot.pidDrive.setDirection(m_direction);
		Robot.pidDrive.setDrive_speed(m_speed);
		Robot.pidDrive.enable();
		Robot.pidDrive.setSetpoint(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.encoderRight.getDistance()) > m_distance);
	}

	protected void end() {
		Robot.pidDrive.disable();
		RobotMap.driveTrain.curvatureDrive(0, 0, false);
	}
}
