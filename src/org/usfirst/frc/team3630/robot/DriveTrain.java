package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Ultrasonic;

public class DriveTrain {
	
	SmartDashboard dashboard;
	
	Joystick leftStick;
	Joystick rightStick;
	
	int LeftFrontChannel;
	int LeftRearChannel;
	int RightFrontChannel;
	int RightRearChannel;
	
	RobotDrive mainDrive;
	
	int sonarChannelIn;
	int sonarChannelOut;
	
	Ultrasonic sonar;
	
	
	public DriveTrain(int lfChannel, int lrChannel, 
					  int rfChannel, int rrChannel, 
					  Joystick lStick, Joystick rStick, 
					  int sonarChIn, int sonarChOut,
					  SmartDashboard dashb) {
		
		LeftFrontChannel = lfChannel;
		LeftRearChannel = lrChannel;
		RightFrontChannel = rfChannel;
		RightRearChannel = rrChannel;
		
		leftStick = lStick;
		rightStick = rStick;
		
		sonarChannelIn = sonarChIn;
		sonarChannelOut = sonarChOut;
		
		dashboard = dashb;
	}
	
	public void driveTrainInit() {
		
		mainDrive = new RobotDrive(LeftFrontChannel, LeftRearChannel, 
								   RightFrontChannel, RightRearChannel);
		mainDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		mainDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		mainDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		mainDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		sonar = new Ultrasonic(sonarChannelIn, sonarChannelOut);
		sonar.setEnabled(true);
		sonar.setAutomaticMode(true);
		
	}
	
	public void driveTrainPeriodic() {
		
		if(!leftStick.getRawButton(1)) {
			mainDrive.mecanumDrive_Cartesian(leftStick.getX(), leftStick.getY(), 
										 	 rightStick.getX(), 0);
		}
		else {
			mainDrive.mecanumDrive_Cartesian(leftStick.getX() / 4, leftStick.getY() / 4, 
											 rightStick.getX() / 4, 0);
		}
		
	}
	
}
