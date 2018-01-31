package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command{

	private double speed;
	private double setpoint;
	
	public TurnToAngle(double speed, double setpoint) {
		this.speed = speed;
		this.setpoint = setpoint;
	}
	
	protected void initialize() {
		Robot.pidTurn.setTurn_speed(speed);
		Robot.pidTurn.enable();
		Robot.pidTurn.setSetpoint(setpoint);
	}
	
	@Override
	protected boolean isFinished() {
		return  Math.abs(RobotMap.navx.getAngle()) >= Math.abs(Robot.pidTurn.getSetpoint()) ;
	}

	protected void end() {
		Robot.pidTurn.disable();
		Robot.driveTrain.Driving(0,0);
	}
}
