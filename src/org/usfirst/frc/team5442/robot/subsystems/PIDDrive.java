package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDDrive extends PIDSubsystem{

	public double drive_speed;
	public int direction; //direction must be +1 or -1
	
	public PIDDrive() {
		super("Straight Driving", .1, 0, 0);
		setAbsoluteTolerance(5.0);
		setOutputRange(-1, 1);
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.driveTrain.curvatureDrive(drive_speed, direction*output, false);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
