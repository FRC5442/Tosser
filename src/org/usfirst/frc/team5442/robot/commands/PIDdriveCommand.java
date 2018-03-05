package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDdriveCommand extends PIDCommand{

	double m_distance;
	double m_speed;
	int m_direction;
	
	public PIDdriveCommand(
			double distance, double speed, int direction) {
		super("Straight DrivingPID", .1, .001, 0);
		m_distance = distance;
		m_speed = speed;
		m_direction = direction; // positive or negative 1
	}
	
	protected void initialize() {
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
		//setSetpointRelative(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.encoderRight.getDistance()) > m_distance);
	}

	protected void end() {
		RobotMap.driveTrain.curvatureDrive(0, 0, false);
		//RobotMap.driveTrain.stopMotor();
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		//RobotMap.driveTrain.curvatureDrive(.35, output, false);
		RobotMap.driveTrain.curvatureDrive(m_speed, 0, false);
	}
}