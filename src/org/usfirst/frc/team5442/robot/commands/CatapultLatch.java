package org.usfirst.frc.team5442.robot.commands;

import org.usfirst.frc.team5442.robot.Robot;
import org.usfirst.frc.team5442.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

	public class CatapultLatch extends Command{
		@Override
		protected void initialize() {
			RobotMap.compressor.stop();
			if (RobotMap.shooterLatch.get() == DoubleSolenoid.Value.kReverse) {
				Robot.pneumatics.shooterLatching(DoubleSolenoid.Value.kForward);
			}
			else {
				Robot.pneumatics.shooterLatching(DoubleSolenoid.Value.kReverse);
			}
		}

		@Override
		protected boolean isFinished() {
			return true;
		}
		protected void end() {
			RobotMap.compressor.start();
		}

	}