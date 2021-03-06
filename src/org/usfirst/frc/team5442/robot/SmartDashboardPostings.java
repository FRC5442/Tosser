package org.usfirst.frc.team5442.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardPostings {

	public SmartDashboardPostings() {
		
	}
	public static void updateAutoValues() {
		//SmartDashboard.putNumber("Flip Encoder", RobotMap.flipEncoder.getDistance());
		SmartDashboard.putNumber("NavX Angle", RobotMap.navx.getAngle());
		SmartDashboard.putBoolean("Catapult Limit Switch", RobotMap.catapultSwitch.get());
		SmartDashboard.putNumber("Left Encoder", RobotMap.encoderLeft.getDistance());
		SmartDashboard.putNumber("Right Encoder", RobotMap.encoderRight.getDistance());
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void updateTeleopValues() {
		SmartDashboard.putBoolean("Compressor Running", RobotMap.compressor.enabled());
		SmartDashboard.putBoolean("Shooter Armed", !RobotMap.catapultSwitch.get());
//		SmartDashboard.putNumber("Flip Encoder", RobotMap.flipEncoder.getDistance());
//		SmartDashboard.putNumber("Left Encoder", RobotMap.encoderLeft.getDistance());
//		SmartDashboard.putNumber("Right Encoder", RobotMap.encoderRight.getDistance());
//		SmartDashboard.putNumber("NavX Angle", RobotMap.navx.getAngle());
		SmartDashboard.putBoolean("Pincer State", RobotMap.pincer.equals(DoubleSolenoid.Value.kForward));
		SmartDashboard.putBoolean("Intake Limit Switch", !RobotMap.intakeLimitSwitch.get());
		//SmartDashboard.putNumber("Winch Direction", Math.signum(RobotMap.winchMotor.getSpeed()));

		
		//SmartDashboard.putBoolean("PDP Voltage Less Than 12", RobotMap.pdp.getVoltage() <= 12);
	}
	
	public static void updateTestingValues() {
		//SmartDashboard.putNumber("PDP0", RobotMap.pdp.getCurrent(0));
		//SmartDashboard.putNumber("PDP1", RobotMap.pdp.getCurrent(1));
		//SmartDashboard.putNumber("PDP2", RobotMap.pdp.getCurrent(2));
		//SmartDashboard.putNumber("PDP5", RobotMap.pdp.getCurrent(5));
		//SmartDashboard.putNumber("PDP6", RobotMap.pdp.getCurrent(6));
		//SmartDashboard.putNumber("PDP7", RobotMap.pdp.getCurrent(7));
	}
}
