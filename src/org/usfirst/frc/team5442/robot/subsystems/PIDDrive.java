package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDDrive extends PIDSubsystem{

	private double drive_speed;
	private int direction; //direction must be +1 or -1
	
	public PIDDrive() {
		super("Straight Driving", .1, .001, 0);
		setAbsoluteTolerance(5.0);
		setInputRange(-180, 180);
		setOutputRange(-1, 1);
		getPIDController().setContinuous();
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getPitch();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.driveTrain.curvatureDrive(getDrive_speed(), getDirection()*output, false);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public double getDrive_speed() {
		return drive_speed;
	}

	public void setDrive_speed(double drive_speed) {
		this.drive_speed = drive_speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
