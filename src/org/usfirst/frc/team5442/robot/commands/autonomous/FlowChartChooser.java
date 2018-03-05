package org.usfirst.frc.team5442.robot.commands.autonomous;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;

public class FlowChartChooser { //extends Command {
	private OurSideChoice _ourSide;
	private PrimaryObjectiveChoice _primaryObjective;
	private CrossMiddleChoice _crossMiddle;
	private EnableSecondaryChoice _enableSecondary;
	private AutoCodes _THEautoCode;
	private String gameData;
	
	public FlowChartChooser(OurSide os, PrimaryObjective po, CrossMiddle cm, EnableSecondary es) {
		_ourSide = os.get_choice();
		_primaryObjective = po.get_choice();
		_crossMiddle = cm.get_choice();
		_enableSecondary = es.get_choice();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		_THEautoCode = AutoCodes.Undefined;
	}

	private String TheCodes = "_UD_UD_UD_UD_UD";
	private void ProcessWithStingCode() {
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
		return codesAsChars.toString();
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
	
	private void RunAutonomous() {
		if(CheckCodes(TheCodes, "_LF_SC_**_**_*L")) {
			//Drive left-left path to scale
		}
		else if(CheckCodes(TheCodes, "_LF_Sw_**_**_L*")) {
			//Drive left-left path to switch
		}
		else if(CheckCodes(TheCodes, "_RT_SC_**_**_*R")) {
			//Drive right-right path to scale
		}
		else if(CheckCodes(TheCodes, "_RT_Sw_**_**_R*")) {
			//Drive right-right path to switch
		}
		else if(CheckCodes(TheCodes, "_MD_Sw_**_**_L*")) {
			//Drive middle-left path to switch
		}
		else if(CheckCodes(TheCodes, "_MD_Sw_**_**_R*")) {
			//Drive middle-right path to switch
		}

		//DEFAULTS
		else if(CheckCodes(TheCodes, "_LF_**_**_**_**")) {
			//Drive left-left path to auto-line
		}
		else if(CheckCodes(TheCodes, "_RT_**_**_**_**")) {
			//Drive right-right path to auto-line
		}
		else if(CheckCodes(TheCodes, "_MD_**_**_**_**")) {
			//Drive middle path to auto-line
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
