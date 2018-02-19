package org.usfirst.frc.team5442.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;

public class FlowChartChooser { //extends Command {
	private OurSideChoice _ourSide;
	private PrimaryObjectiveChoice _primaryObjective;
	private CrossMiddleChoice _crossMiddle;
	private DisableScaleChoice _disableScale;
	private DisableSwitchChoice _disableSwitch;
	private AutoCodes _THEautoCode;
	private String gameData;
	
	public FlowChartChooser(OurSide os, PrimaryObjective po, CrossMiddle cm, DisableScale dsc, DisableSwitch dsw) {
		_ourSide = os.get_choice();
		_primaryObjective = po.get_choice();
		_crossMiddle = cm.get_choice();
		_disableScale = dsc.get_choice();
		_disableSwitch = dsw.get_choice();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		_THEautoCode = AutoCodes.Undefined;
	}
	
	private void ProcessFlowchart() {
		if (_ourSide == OurSideChoice.Left) {
			if (_primaryObjective == PrimaryObjectiveChoice.Switch) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						_THEautoCode = AutoCodes.LeftSide_LeftSwitch; // Put box in left switch, cross baseline
					} else if (gameData.charAt(0) == 'R') {
						if (gameData.charAt(1) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.LeftSide_RightSwitch; // cross middle, go for right side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								
								_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
							} else {
								_THEautoCode = AutoCodes.Undefined; // Place Undefined Code Here
							}
						} else if (gameData.charAt(1) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.LeftSide_RightSwitch; // Cross Middle, go for right side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableScale == DisableScaleChoice.Yes) {
									_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
								} else if (_disableScale == DisableScaleChoice.No) {
									_THEautoCode = AutoCodes.LeftSide_LeftScale; // Go for left Scale
								} else {
									_THEautoCode = AutoCodes.Undefined; // Place Undefined Code here
								}
							} else {
								_THEautoCode = AutoCodes.Undefined; // Put undefined code here
							}
						} else {
							_THEautoCode = AutoCodes.Undefined; // Put undefined code here
						}
					} 
					
				}
			} else if (_primaryObjective == PrimaryObjectiveChoice.Scale) {
				if (gameData.length() > 0) {
					if (gameData.charAt(1) =='L') {
						_THEautoCode = AutoCodes.LeftSide_LeftScale; // Cross Baseline, go for scale
					} else if (gameData.charAt(1) == 'R') {
						if (gameData.charAt(0) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.LeftSide_RightScale; // Cross middle, go for right scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableSwitch == DisableSwitchChoice.Yes) {
									_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
								} else if (_disableSwitch == DisableSwitchChoice.No) {
									_THEautoCode = AutoCodes.LeftSide_LeftSwitch; // Go for left switch
								} else {
									_THEautoCode = AutoCodes.Undefined; // Place undefined code here
								}
							} else {
								_THEautoCode = AutoCodes.Undefined; // place undefined code here
							}
						} else if (gameData.charAt(0) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.LeftSide_RightScale; // Cross Middle, go for right side of scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
							} else {
								_THEautoCode = AutoCodes.Undefined; // Place Undefined Code Here
							}
						} else {
							_THEautoCode = AutoCodes.Undefined; // place undefined code here
						}
					} else {
						_THEautoCode = AutoCodes.Undefined; // Place undefined code here
					}
				} else {
					_THEautoCode = AutoCodes.Undefined;// plase undefined code here
				}
				
			} else if (_primaryObjective == PrimaryObjectiveChoice.Autoline) {
				_THEautoCode = AutoCodes.Undefined; // Cross Baseline
			} else {
				_THEautoCode = AutoCodes.Undefined; // Place Undefined Code Here
			}
		} else if (_ourSide == OurSideChoice.Middle) {
			if (_disableSwitch == DisableSwitchChoice.Yes) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						_THEautoCode = AutoCodes.Middle_BaseLine_Left; // Cross Baseline on left of switch
					} else if (gameData.charAt(0) == 'L') {
						_THEautoCode = AutoCodes.Middle_BaseLine_Right; // Cross Baseline on Right of Switch
					} else {
						_THEautoCode = AutoCodes.Undefined; // Place undefined code here
					}
				} else {
					_THEautoCode = AutoCodes.Undefined; // Place undefined code here
				}
			} else if (_disableSwitch == DisableSwitchChoice.No) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						_THEautoCode = AutoCodes.Middle_RightSwitch; // Put box in right side of switch, then cross baseline
					} else if (gameData.charAt(0) == 'L') {
						_THEautoCode = AutoCodes.Middle_LeftSwitch; // Put box in left side of switch, then cross baseline
					} else {
						_THEautoCode = AutoCodes.Undefined; // Place undefined code here
					}
				} else {
					_THEautoCode = AutoCodes.Undefined; // place undefined code here
				}
			} else {
				_THEautoCode = AutoCodes.Undefined; // Place undefined code here
			}
			
		} else if(_ourSide == OurSideChoice.Right) {
			if (_primaryObjective == PrimaryObjectiveChoice.Switch) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						_THEautoCode = AutoCodes.RightSide_RightSwitch; // Put box in right switch, cross baseline
					} else if (gameData.charAt(0) == 'L') {
						if (gameData.charAt(1) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.RightSide_LeftSwitch; // Cross middle, go for left side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
							} else {
								_THEautoCode = AutoCodes.LeftOrRight_Baseline;// place undefined code here
							}
						} else if (gameData.charAt(1) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableScale == DisableScaleChoice.Yes) {
									_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
								} else if (_disableScale == DisableScaleChoice.No) {
									_THEautoCode = AutoCodes.RightSide_RightScale; // Go for scale
								} else {
									_THEautoCode = AutoCodes.Undefined; // Place undefined code here
								}
							} else if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.RightSide_LeftSwitch; // Cross middle, go for Left side of switch
							} else {
								_THEautoCode = AutoCodes.Undefined; // place Undefined code here
							}
						} else {
							_THEautoCode = AutoCodes.Undefined; // Place undefined code here
						}
					} else {
						_THEautoCode = AutoCodes.Undefined; // Place undefined code
					}
				} else {
					_THEautoCode = AutoCodes.Undefined; // place Undefined code here
				}
			} else if (_primaryObjective == PrimaryObjectiveChoice.Autoline) {
				_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross baseline
			} else if (_primaryObjective == PrimaryObjectiveChoice.Scale) {
				if (gameData.length() > 0) {
					if (gameData.charAt(1) == 'R') {
						_THEautoCode = AutoCodes.RightSide_RightScale; // Cross Baseline, go for scale
					} else if (gameData.charAt(1) == 'L') {
						if (gameData.charAt(0) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.RightSide_LeftScale; // Cross middle, go for Left scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableSwitch == DisableSwitchChoice.Yes) {
									_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
								} else if (_disableSwitch == DisableSwitchChoice.No) {
									_THEautoCode = AutoCodes.RightSide_RightSwitch; // Go for Right Switch
								} else {
									_THEautoCode = AutoCodes.Undefined; // place Undefined code here
								}
							} else {
								_THEautoCode = AutoCodes.Undefined; // place Undefined code here
							}
						} else if (gameData.charAt(0) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								_THEautoCode = AutoCodes.RightSide_LeftScale; // Cross Middle, go for left side of scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								_THEautoCode = AutoCodes.LeftOrRight_Baseline; // Cross Baseline
							} else {
								_THEautoCode = AutoCodes.Undefined; // Put undefined code here
							}
						} else {
							_THEautoCode = AutoCodes.Undefined; // Place undefined code here
						}
					} else {
						_THEautoCode = AutoCodes.Undefined; // Place undefined code here
					}
				} else {
					_THEautoCode = AutoCodes.Undefined; // Place undefined code
				}
			} else {
				_THEautoCode = AutoCodes.Undefined; // Place undefined code here
			}
		} else {
			_THEautoCode = AutoCodes.Undefined; // Place undefined thing here
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
			TheCodes = SetCode(TheCodes, 2, "_");
			break;
		case No:
			TheCodes = SetCode(TheCodes, 2, "_");
			break;
		}
		switch(_disableScale) {
		case Yes:
			TheCodes = SetCode(TheCodes, 1, "_AL");
			break;
		case No:
			TheCodes = SetCode(TheCodes, 1, "_SC");
			break;
		}
		switch(_disableSwitch) {
		case Yes:
			TheCodes = SetCode(TheCodes, 1, "_AL");
			break;
		case No:
			TheCodes = SetCode(TheCodes, 1, "_SW");
			break;
		}
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
}
