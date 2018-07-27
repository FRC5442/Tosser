package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDDriveCommand extends PIDCommand{

	double _encoderDistance;
	double _speed;
	/**double _ratio = 0.796; //how many inches per encoder rotation
	double _rollout = 3.57;**/
	double _ratio = 1.1438;
	double _rollout = 6.4748;
	//.796x-3.57
	//.8742x+5.6578
	//20, 23.14
	//70, 66.86
	//100, 93.1
	//130, 119.3
	
	public PIDDriveCommand(
			double distanceInInches, double speed) {
		super("Straight DrivingPID", 0.015, 0.00, 0);
		//.1 not in mpr?
		_speed = speed;
		_encoderDistance = distanceInInches * _ratio -  _rollout;
		
		
		
	}
	
	protected void initialize() {
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
		setSetpointRelative(0);
	}
	
	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.encoderRight.getDistance()) > _encoderDistance);
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
		RobotMap.driveTrain.curvatureDrive(_speed, output, false);
		//RobotMap.driveTrain.curvatureDrive(_speed, 0, false);
	}
}