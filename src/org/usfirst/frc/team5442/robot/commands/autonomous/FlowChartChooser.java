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
	private void ProcessFlowchart() {
		if (_ourSide == OurSideChoice.Left) {
			if (_primaryObjective == PrimaryObjectiveChoice.Switch) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						// Put box in left switch, cross baseline
					} else if (gameData.charAt(0) == 'R') {
						if (gameData.charAt(1) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// cross middle, go for right side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								// Cross Baseline
							} else {
								// Place Undefined Code here
							}
						} else if (gameData.charAt(1) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross Middle, go for right side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableScale == DisableScaleChoice.Yes) {
									// Cross Baseline
								} else if (_disableScale == DisableScaleChoice.No) {
									// Go for left Scale
								} else {
									// Place Undefined Code here
								}
							} else {
								// Put undefined code here
							}
						} else {
							// Put undefined code here
						}
					} 
					
				}
			} else if (_primaryObjective == PrimaryObjectiveChoice.Scale) {
				if (gameData.length() > 0) {
					if (gameData.charAt(1) =='L') {
						// Cross Baseline, go for scale
					} else if (gameData.charAt(1) == 'R') {
						if (gameData.charAt(0) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross middle, go for right scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableSwitch == DisableSwitchChoice.Yes) {
									// Cross Baseline
								} else if (_disableSwitch == DisableSwitchChoice.No) {
									// Go for left switch
								} else {
									// Place undefined code here
								}
							} else {
								// place undefined code here
							}
						} else if (gameData.charAt(0) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross Middle, go for right side of scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								// Cross Baseline
							} else {
								// Place Undefined Code Here
							}
						} else {
							// place undefined code here
						}
					} else {
						// Place undefined code here
					}
				} else {
					// plase undefined code here
				}
				
			} else if (_primaryObjective == PrimaryObjectiveChoice.Autoline) {
				// Cross Baseline
			} else {
				// Place Undefined Code Here
			}
		} else if (_ourSide == OurSideChoice.Middle) {
			if (_disableSwitch == DisableSwitchChoice.Yes) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						// Cross Baseline on left of switch
					} else if (gameData.charAt(0) == 'L') {
						// Cross Baseline on Right of Switch
					} else {
						// Place undefined code here
					}
				} else {
					// Place undefined code here
				}
			} else if (_disableSwitch == DisableSwitchChoice.No) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						// Put box in right side of switch, then cross baseline
					} else if (gameData.charAt(0) == 'L') {
						// Put box in left side of switch, then cross baseline
					} else {
						// Place undefined code here
					}
				} else {
					// place undefined code here
				}
			} else {
				// Place undefined code here
			}
			
		} else if(_ourSide == OurSideChoice.Right) {
			if (_primaryObjective == PrimaryObjectiveChoice.Switch) {
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'R') {
						// Put box in right switch, cross baseline
					} else if (gameData.charAt(0) == 'L') {
						if (gameData.charAt(1) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross middle, go for left side of switch
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								// Cross Baseline
							} else {
								// place undefined code here
							}
						} else if (gameData.charAt(1) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableScale == DisableScaleChoice.Yes) {
									// Cross Baseline
								} else if (_disableScale == DisableScaleChoice.No) {
									// Go for scale
								} else {
									// Place undefined code here
								}
							} else if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross middle, go for Left side of switch
							} else {
								// place Undefined code here
							}
						} else {
							// Place undefined code here
						}
					} else {
						// Place undefined code
					}
				} else {
					// place Undefined code here
				}
			} else if (_primaryObjective == PrimaryObjectiveChoice.Autoline) {
				// Cross baseline
			} else if (_primaryObjective == PrimaryObjectiveChoice.Scale) {
				if (gameData.length() > 0) {
					if (gameData.charAt(1) == 'R') {
						// Cross Baseline, go for scale
					} else if (gameData.charAt(1) == 'L') {
						if (gameData.charAt(0) == 'R') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross middle, go for Left scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								if (_disableSwitch == DisableSwitchChoice.Yes) {
									// Cross Baseline
								} else if (_disableSwitch == DisableSwitchChoice.No) {
									// Go for Right Switch
								} else {
									// place Undefined code here
								}
							} else {
								// place Undefined code here
							}
						} else if (gameData.charAt(0) == 'L') {
							if (_crossMiddle == CrossMiddleChoice.Yes) {
								// Cross Middle, go for left side of scale
							} else if (_crossMiddle == CrossMiddleChoice.No) {
								// Cross Baseline
							} else {
								// Put undefined code here
							}
						} else {
							// Place undefined code here
						}
					} else {
						// Place undefined code here
					}
				} else {
					// Place undefined code
				}
			} else {
				// Place undefined code here
			}
		} else {
			// Place undefined thing here
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
