package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;

public class FlowChartChooser { //extends Command {
	private OurSideChoice _ourSide;
	private PrimaryObjectiveChoice _primaryObjective;
	private CrossMiddleChoice _crossMiddle;
	private DisableScaleChoice _disableScale;
	private DisableSwitchChoice _disableSwitch;
	private String gameData;
	public FlowChartChooser(OurSide os, PrimaryObjective po, CrossMiddle cm, DisableScale dsc, DisableSwitch dsw) {
		_ourSide = os.get_choice();
		_primaryObjective = po.get_choice();
		_crossMiddle = cm.get_choice();
		_disableScale = dsc.get_choice();
		_disableSwitch = dsw.get_choice();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public void cancel() {
		
	}
	
	public void start() {
		
	}
	
	
/*	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		
	}
	
	@Override
	protected void interrupted() {
		
	}
*/
}
