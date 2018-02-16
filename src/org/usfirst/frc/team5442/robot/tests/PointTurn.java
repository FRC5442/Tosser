package org.usfirst.frc.team5442.robot.tests;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PointTurn extends Command{

	private double initialAngle, speed, endAngle, direction;
	
	public PointTurn(double endAngle){
		this.endAngle = endAngle;
	}
	
	protected void initialize() {
		Timer.delay(0.2);
		this.initialAngle = RobotMap.navx.getAngle();
		this.direction = Math.signum(endAngle);
		speed = 0;
		SmartDashboard.putNumber("Direction", direction);
	}

	protected void execute() {
		if(Math.abs(initialAngle - RobotMap.navx.getAngle()) < 3 && Math.abs(speed) < 1) {
			speed = speed + .02;
		}
		else if(Math.abs(initialAngle - RobotMap.navx.getAngle()) < 10 && Math.abs(speed) < 1) {
			speed = speed + .004;
		}
		else if (Math.abs(endAngle - RobotMap.navx.getAngle()) < 25 && Math.abs(speed) > .1) {
			speed = speed - .08;
		}
		RobotMap.GetDriver().curvatureDrive(0, direction*speed, true);
		//RobotMap.GetDriver().tankDrive(direction*speed, -direction*speed);
		SmartDashboard.putNumber("Initial Angle", initialAngle);
		SmartDashboard.putNumber("End Angle", endAngle);
		SmartDashboard.putNumber("End Point", endAngle + initialAngle);
		SmartDashboard.putNumber("Speed", speed);
	}
	
	@Override
	protected boolean isFinished() {
		return Math.abs(RobotMap.navx.getAngle() - (initialAngle + endAngle)) < 15;
	}

	protected void end() {
		RobotMap.GetDriver().tankDrive(0, 0);
	}
}
