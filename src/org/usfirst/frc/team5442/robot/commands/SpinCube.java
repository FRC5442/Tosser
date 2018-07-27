package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SpinCube extends Command{

	Timer tim = new Timer();
	double _time, _speed;
	
	public SpinCube(double time, double speed) {
		_time = time;
		_speed = speed;
	}
	
	protected void initialize() {
		tim.reset();
		tim.start();
	}
	
	protected void execute() {
		RobotMap.rightIntake.set(-_speed);
		RobotMap.leftIntake.set(-.55);

	}
	
	@Override
	protected boolean isFinished() {
		return tim.get() > _time || !RobotMap.intakeLimitSwitch.get();
		
	}

	protected void end() {
		RobotMap.rightIntake.set(0);
		RobotMap.leftIntake.set(0);
		tim.stop();
		if(!RobotMap.intakeLimitSwitch.get())
			RobotMap.pincer.set(DoubleSolenoid.Value.kForward);
	}
}
