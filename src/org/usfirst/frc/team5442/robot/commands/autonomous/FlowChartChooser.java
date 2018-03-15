package org.usfirst.frc.team5442.robot.commands.autonomous;

import java.util.ArrayList;

import org.usfirst.frc.team5442.robot.commandgroups.AutoLineOnly;
import org.usfirst.frc.team5442.robot.commandgroups.LeftSCL;
import org.usfirst.frc.team5442.robot.commandgroups.LeftSWL;
import org.usfirst.frc.team5442.robot.commandgroups.MidALL;
import org.usfirst.frc.team5442.robot.commandgroups.MidALR;
import org.usfirst.frc.team5442.robot.commandgroups.MidSWL;
import org.usfirst.frc.team5442.robot.commandgroups.MidSWR;
import org.usfirst.frc.team5442.robot.commandgroups.RightSCR;
import org.usfirst.frc.team5442.robot.commandgroups.RightSWR;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class FlowChartChooser { //extends Command {
	private OurSideChoice _ourSide;
	private PrimaryObjectiveChoice _primaryObjective;
	private CrossMiddleChoice _crossMiddle;
	private EnableSecondaryChoice _enableSecondary;
	private AutoCodes _THEautoCode;
	private String gameData;
	
	public FlowChartChooser(SendableChooser<Command> ourSide, SendableChooser<Command> primaryObjective, SendableChooser<Command> crossMiddle, SendableChooser<Command> enableSecondary) {
		_ourSide = ((OurSide) ourSide.getSelected()).get_choice();
		_primaryObjective = ((PrimaryObjective) primaryObjective.getSelected()).get_choice();
		_crossMiddle = ((CrossMiddle) crossMiddle.getSelected()).get_choice();
		_enableSecondary = ((EnableSecondary) enableSecondary.getSelected()).get_choice();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		_THEautoCode = AutoCodes.Undefined;
	}

	private String TheCodes = "_UD_UD_UD_UD_UD";
	public void ProcessWithStingCode() {
		switch(_ourSide) {
		case Left:
			TheCodes = SetCode(TheCodes, 0, "_LF");
			break;
		case Right:
			TheCodes = SetCode(TheCodes, 0, "_RT");
			break;
		case Middle:
			TheCodes = SetCode(TheCodes, 0, "_MD");
			break;
		case custom:
			TheCodes = SetCode(TheCodes, 0, "_CU");
		}
		switch(_primaryObjective) {
		case Scale:
			TheCodes = SetCode(TheCodes, 1, "_SC");
			break;
		case Switch:
			TheCodes = SetCode(TheCodes, 1, "_SW");
			break;
		case Autoline:
			TheCodes = SetCode(TheCodes, 1, "_AL");
			break;
		}
		switch(_crossMiddle) {
		case Yes:
			TheCodes = SetCode(TheCodes, 2, "_YS");
			break;
		case No:
			TheCodes = SetCode(TheCodes, 2, "_NO");
			break;
		}
		switch(_enableSecondary) {
		case Yes:
			TheCodes = SetCode(TheCodes, 3, "_ES");
			break;
		case No:
			TheCodes = SetCode(TheCodes, 3, "_DS");
			break;
		}
		TheCodes = SetCode(TheCodes, 4, "_" + gameData.charAt(0) + gameData.charAt(1));
	}
	
	private String SetCode(String codes, int codePosition, String code) {
		int insertIndex = codePosition * 3;
		char[] codesAsChars = codes.toCharArray();
		char[] newCodeAsChars = code.toCharArray();
		codesAsChars[insertIndex] = newCodeAsChars[0];
		codesAsChars[insertIndex + 1] = newCodeAsChars[1];
		codesAsChars[insertIndex + 2] = newCodeAsChars[2];
		return new String(codesAsChars);
	}
	
	private boolean CheckCodes(String codes, ArrayList<String> matches) {
		boolean isMatch = false;
		
		for(String match : matches) {
			if(CheckCodes(codes, match))
				isMatch = true;
		}
		
		return isMatch;
	}
	
	private boolean CheckCodes(String codes, String match) {
		boolean isMatch = true;
		
		for(int i = 0; i < 5; i++) {
			if(!CodeMatch(codes, match, i)) {
				isMatch = false;
			}
		}
		
		return isMatch;
	}
	
	private boolean CodeMatch(String codes, String match, int position) {
		int index = position * 3;
		char wildcard = '*';
		
		return (match.toCharArray()[index + 1] == wildcard || match.toCharArray()[index + 1] == codes.toCharArray()[index + 1])
				&& (match.toCharArray()[index + 2] == wildcard || match.toCharArray()[index + 2] == codes.toCharArray()[index + 2]);
	}
	
	public void RunAutonomous() {
		if(CheckCodes(TheCodes, "_CU_**_**_**_**")) {
			// RUN CUSTOM AUTO CODE 
		}
		
		else if(CheckCodes(TheCodes, "_LF_SC_**_**_*L")) {
			//Drive left-left path to scale
			new LeftSCL();
		}
		else if(CheckCodes(TheCodes, "_LF_SW_**_**_L*")) {
			//Drive left-left path to switch
			new LeftSWL();
		}
		else if(CheckCodes(TheCodes, "_RT_SC_**_**_*R")) {
			//Drive right-right path to scale
			new RightSCR();
		}
		else if(CheckCodes(TheCodes, "_RT_SW_**_**_R*")) {
			//Drive right-right path to switch
			new RightSWR();
		}
		else if(CheckCodes(TheCodes, "_MD_SW_**_**_L*")) {
			//Drive middle-left path to switch
			new MidSWL();
		}
		else if(CheckCodes(TheCodes, "_MD_SW_**_**_R*")) {
			//Drive middle-right path to switch
			new MidSWR();
		}

		//DEFAULTS
		else if(CheckCodes(TheCodes, "_LF_**_**_**_**")) {
			//Drive left-left path to auto-line
			new AutoLineOnly();
		}
		else if(CheckCodes(TheCodes, "_RT_**_**_**_**")) {
			//Drive right-right path to auto-line
			new AutoLineOnly();
		}
		else if(CheckCodes(TheCodes, "_MD_**_**_**_R*")) {
			//Drive middle path to left auto-line
			new MidALL();
		}
		else if(CheckCodes(TheCodes, "_MD_**_**_**_L*")) {
			// Drive middle path to right auto-line
			new MidALR();
		}
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
