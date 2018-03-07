package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDDriveCommand extends PIDCommand{

	double m_encoderDistance;
	double m_speed;
	int m_direction;
	double m_ratio = 3.35; //how many inches per encoder rotation
	double m_inchDistance;
	
	public PIDDriveCommand(
			double distance, double speed, int direction) {
		super("Straight DrivingPID", .1, .001, 0);
		m_inchDistance = distance;
		m_speed = speed;
		m_direction = direction; // positive or negative 1
		m_encoderDistance = m_ratio * distance;
		
		
		
	}
	
	protected void initialize() {
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
		//setSetpointRelative(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.encoderRight.getDistance()) > m_encoderDistance);
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