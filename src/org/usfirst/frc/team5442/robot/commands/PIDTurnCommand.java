package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDTurnCommand extends PIDCommand{

	double angle;
	public PIDTurnCommand(double angle) {
		super(.01, 0.05, 0.001);
		this.angle = angle;
	}

	protected void initialize() {
		setSetpoint(RobotMap.navx.getAngle() + angle);
	}
	
	@Override
	protected boolean isFinished() {
		return getSetpoint() == RobotMap.navx.getAngle();
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.driveTrain.curvatureDrive(0, output, true);
	}

}