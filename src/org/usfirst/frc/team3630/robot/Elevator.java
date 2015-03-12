package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;

public class Elevator {
	
	SmartDashboard dashboard;
	
	int motorChannel;
	boolean motorReversal;
	
	Talon motor;
	
	int encoderChannelIn;
	int encoderChannelOut;
	boolean encoderReversal;
	
	Encoder encoder;
	
	
	public Elevator(int channel, int encChIn, int encChOut, 
					boolean encRev, boolean motorRev, SmartDashboard dashb) {
		
		dashboard = dashb;
		
		motorChannel = channel;
		motorReversal = motorRev;
		
		encoderChannelIn = encChIn;
		encoderChannelOut = encChOut;
		encoderReversal = encRev;
	}

	public void elevatorInit() {
		
		motor = new Talon(motorChannel);
		
		encoder = new Encoder(encoderChannelIn, encoderChannelOut, encoderReversal);
		encoder.reset();
		
	}
	
	public void moveUp() {
		if(motorReversal) {
			motor.set(1.0);
		}
		else {
			motor.set(-1.0);
		}
	}
	
	public void moveDown() {
		if(motorReversal) {
			motor.set(-1.0);
		}
		else {
			motor.set(1.0);
		}
	}
	
	public void stop() {
		motor.stopMotor();
	}
	
}
