
package org.usfirst.frc.team3630.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//Dashboard
	SmartDashboard dashboard;
	
	//DriveTrain
	Joystick leftStick;
	Joystick rightStick;
	
	int LeftFrontMotorChannel;
	int LeftRearMotorChannel;
	int RightFrontMotorChannel;
	int RightRearMotorChannel;
	
	int sonarChannelIn;
	int sonarChannelOut;
	
	DriveTrain driveTrain;
	
	//Manipulator
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
	
	Manipulator manipulator;
	
	
    public void robotInit() {
    	
    	//Dashboard
    	dashboard = new SmartDashboard();
    	
    	//DriveTrain
    	leftStick = new Joystick(1);
    	rightStick = new Joystick(2);
    	
    	LeftFrontMotorChannel = 1;
    	LeftRearMotorChannel = 2;
    	RightFrontMotorChannel = 3;
    	RightRearMotorChannel = 4;
    	
    	sonarChannelIn = 8;
    	sonarChannelOut = 9;
    	
    	driveTrain = new DriveTrain(LeftFrontMotorChannel, LeftRearMotorChannel, 
    								RightFrontMotorChannel, RightRearMotorChannel, 
    								leftStick, rightStick,
    								sonarChannelIn, sonarChannelOut,
    								dashboard);
    	driveTrain.driveTrainInit();
    	
    	//Manipulator
    	manipulatorStick = new Joystick(3);
    	
    	elevator1MotorChannel = 8;
    	elevator1Reversal = true;
    	elevator2MotorChannel = 7;
    	elevator2Reversal = false;
    	elevator3MotorChannel = 6;
    	elevator3Reversal = false;
    	elevator4MotorChannel = 5;
    	elevator4Reversal = false;
    	
    	encoder1ChannelIn = 0;
    	encoder1ChannelOut = 1;
    	encoder1Reversal = false; //TBC
    	encoder2ChannelIn = 2;
    	encoder2ChannelOut = 3;
    	encoder2Reversal = false; //TBC
    	encoder3ChannelIn = 4;
    	encoder3ChannelOut = 5;
    	encoder3Reversal = false; //TBC
    	encoder4ChannelIn = 6; //TBC
    	encoder4ChannelOut = 7; //TBC
    	encoder4Reversal = false; //TBC
    	
    	limitSwitchUpperChannel = 999; //TBC
    	limitSwitchLowerChannel = 999; //TBC
    	
    	manipulator = new Manipulator(elevator1MotorChannel, elevator2MotorChannel,
    								  elevator3MotorChannel, elevator4MotorChannel,
    								  elevator1Reversal, elevator2Reversal,
    								  elevator3Reversal, elevator4Reversal,
    								  manipulatorStick, 
    								  encoder1ChannelIn, encoder1ChannelOut, encoder1Reversal,
    								  encoder2ChannelIn, encoder2ChannelOut, encoder2Reversal,
    								  encoder3ChannelIn, encoder3ChannelOut, encoder3Reversal,
    								  encoder4ChannelIn, encoder4ChannelOut, encoder4Reversal,
    								  limitSwitchUpperChannel, limitSwitchLowerChannel,
    								  dashboard);
    	manipulator.manipulatorInit();
    	
    }

    public void autonomousInit() {
    	
    }
    
    public void autonomousPeriodic() {

    }

    public void teleopInit() {
    	
    }
    
    public void teleopPeriodic() {
        
    	driveTrain.driveTrainPeriodic();
    	manipulator.manipulatorPeriodic();
    	
    }
    
    public void testPeriodic() {
    
    }
    
}
