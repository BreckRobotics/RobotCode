package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogTrigger;

public class Manipulator {

	SmartDashboard dashboard;
	
	Joystick manipulatorStick;
	
	int elevator1MotorChannel;
	boolean elevator1Reversal;
	int elevator2MotorChannel;
	boolean elevator2Reversal;
	int elevator3MotorChannel;
	boolean elevator3Reversal;
	int elevator4MotorChannel;
	boolean elevator4Reversal;

	int encoder1ChannelIn;
	int encoder1ChannelOut;
	boolean encoder1Reversal;
	int encoder2ChannelIn;
	int encoder2ChannelOut;
	boolean encoder2Reversal;
	int encoder3ChannelIn;
	int encoder3ChannelOut;
	boolean encoder3Reversal;
	int encoder4ChannelIn;
	int encoder4ChannelOut;
	boolean encoder4Reversal;
	
	int limitSwitchUpperChannel;
	int limitSwitchLowerChannel;
	
	AnalogTrigger limitSwitchUpper;
	AnalogTrigger limitSwitchLower;
	
	Elevator[] elevators;
	
	int manualElevatorActive;
	
	
	public Manipulator(int channel1, int channel2, 
					   int channel3, int channel4, 
					   boolean el1Rev, boolean el2Rev,
					   boolean el3Rev, boolean el4Rev,
					   Joystick mStick, 
					   int encCh1In, int encCh1Out, boolean enc1Rev,
					   int encCh2In, int encCh2Out, boolean enc2Rev,
					   int encCh3In, int encCh3Out, boolean enc3Rev,
					   int encCh4In, int encCh4Out, boolean enc4Rev,
					   int limUCh, int limLCh,
					   SmartDashboard dashb) {
		
		dashboard = dashb;
		
		manipulatorStick = mStick;
		
		elevator1MotorChannel = channel1;
		elevator1Reversal = el1Rev;
		elevator2MotorChannel = channel2;
		elevator2Reversal = el2Rev;
		elevator3MotorChannel = channel3;
		elevator3Reversal = el3Rev;
		elevator4MotorChannel = channel4;
		elevator4Reversal = el4Rev;
		
		encoder1ChannelIn = encCh1In;
		encoder1ChannelOut = encCh1Out;
		encoder1Reversal = enc1Rev;
		encoder2ChannelIn = encCh2In;
		encoder2ChannelOut = encCh2Out;
		encoder2Reversal = enc2Rev;
		encoder3ChannelIn = encCh3In;
		encoder3ChannelOut = encCh3Out;
		encoder3Reversal = enc3Rev;
		encoder4ChannelIn = encCh4In;
		encoder4ChannelOut = encCh4Out;
		encoder4Reversal = enc4Rev;
		
		limitSwitchUpperChannel = limUCh;
		limitSwitchLowerChannel = limLCh;
		
	}
	
	
	public void manipulatorInit() {

		elevators = new Elevator[5];
		elevators[1] = new Elevator(elevator1MotorChannel, encoder1ChannelIn, encoder1ChannelOut, 
									encoder1Reversal, elevator1Reversal, dashboard);
		elevators[2] = new Elevator(elevator2MotorChannel, encoder2ChannelIn, encoder2ChannelOut, 
									encoder2Reversal, elevator2Reversal, dashboard);
		elevators[3] = new Elevator(elevator3MotorChannel, encoder3ChannelIn, encoder3ChannelOut,
									encoder3Reversal, elevator3Reversal, dashboard);
		elevators[4] = new Elevator(elevator4MotorChannel, encoder4ChannelIn, encoder4ChannelOut, 
									encoder4Reversal, elevator4Reversal, dashboard);
		
		elevators[1].elevatorInit();
		elevators[2].elevatorInit();
		elevators[3].elevatorInit();
		elevators[4].elevatorInit();
		
		manualElevatorActive = 1; //for manual controls
		
		//limitSwitchUpper = new AnalogTrigger(limitSwitchUpperChannel);
		//limitSwitchLower = new AnalogTrigger(limitSwitchLowerChannel);
		
	}
	
	public void manipulatorPeriodic() {
		
		//Manual controls - switch active elevator
		if(manipulatorStick.getPOV() != -1) {
			
			switch(manipulatorStick.getPOV()) {
			
			case 0:
				elevators[manualElevatorActive].stop();
				manualElevatorActive = 4;
			break;
			
			case 90: 
				elevators[manualElevatorActive].stop();
				manualElevatorActive = 3;
			break;
			
			case 180: 
				elevators[manualElevatorActive].stop();
				manualElevatorActive = 2; 
			break;
			
			case 270: 
				elevators[manualElevatorActive].stop();
				manualElevatorActive = 1;
			break;
			
			}
		}
		
		//Manual controls - move active elevator
		if(manipulatorStick.getRawButton(5) && !manipulatorStick.getRawButton(7)) {
			elevators[manualElevatorActive].moveUp();
		}
		else if(manipulatorStick.getRawButton(7) && !manipulatorStick.getRawButton(5)) {
			elevators[manualElevatorActive].moveDown();
		}
		else {
			elevators[manualElevatorActive].stop();
		}
		
	}
	
}
