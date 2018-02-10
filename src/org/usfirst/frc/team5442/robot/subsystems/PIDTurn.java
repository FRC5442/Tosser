package org.usfirst.frc.team5442.robot.subsystems;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class PIDTurn extends PIDSubsystem{

	private double turn_speed;

	public PIDTurn() {
		super("Turn to Angle PID", .5, 10, 0.1);
		setAbsoluteTolerance(1.0);
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
		RobotMap.driveTrain.curvatureDrive(turn_speed, output, true);
	}

	@Override
	protected void initDefaultCommand() {		
	}

	public double getTurn_speed() {
		return turn_speed;
	}

	public void setTurn_speed(double turn_speed) {
		this.turn_speed = turn_speed;
	}
}
