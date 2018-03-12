package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTurnCommand extends PIDCommand{

	double angle;
	double start;
	Timer tim = new Timer();
	
	public PIDTurnCommand(double angle) {
		super(.02, 0.0001, 0.000003);
		this.angle = angle;
	}

	protected void initialize() {
		RobotMap.navx.reset();
		setSetpoint(angle);
		start = RobotMap.navx.getAngle();
		tim.start();
	}
	
	@Override
	protected boolean isFinished() {
		//return getSetpoint() < RobotMap.navx.getAngle();
		//return angle - RobotMap.navx.getAngle() < 15;
		return tim.get() >= 2.5;
		//return tim.get() >= .25 && Math.abs(RobotMap.encoderLeft.getRate()) < 1;
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.navx.getAngle();
	}
	
	@Override
	protected void end() {
		RobotMap.navx.reset();
		RobotMap.driveTrain.tankDrive(0, 0);
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("Start Angle", start);
		SmartDashboard.putNumber("End Angle", angle);
		SmartDashboard.putNumber("Current Angle", RobotMap.navx.getAngle());
		
		RobotMap.driveTrain.curvatureDrive(0, output, true);
	}

}
