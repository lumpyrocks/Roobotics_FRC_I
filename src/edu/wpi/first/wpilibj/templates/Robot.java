/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    RooJoystick joystick;
    RooDriveTrain rdt;
    RooForkLift fl;
    RooCatapult pult;
    RooKicker kicker;
    RooCosmetics cosmo;
    RooAutoRanger ranger;
    AnalogChannel encoderCatapult;
    AnalogChannel encoderForklift;
    AnalogChannel encoderKicker;
    RooAutonomous auton;
    RooWreakHavoc rwh;
    RooScoreAGoal rsg;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = RooJoystick.getInstance();

        rdt = RooDriveTrain.getInstance();
        fl = RooForkLift.getInstance();
        pult = RooCatapult.getInstance();
        kicker = RooKicker.getInstance();
        cosmo = RooCosmetics.getInstance();
        encoderCatapult = new AnalogChannel(RobotMap.ENCODER_CATAPULT);
        encoderKicker = new AnalogChannel(RobotMap.ENCODER_KICKER);
        encoderForklift = new AnalogChannel(RobotMap.ENCODER_FORKLIFT);
        auton = RooAutonomous.getInstance();
        ranger = RooAutoRanger.getInstance();
        rwh = new RooWreakHavoc();
        rsg = RooScoreAGoal.getInstance();
    }

    
    public void autonomousInit (){
        cosmo.init();
        auton.doAutonomous();
        
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
    }

    public void teleopInit () {
        cosmo.init();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Teleop Periodic Functions as "While(Teleop){}", please do not put indefinite loops within it, this is a bad.
        
        rdt.periodic();
        fl.periodic();
        pult.periodic();
        kicker.periodic();
        ranger.adjustPosition();
        rsg.periodic();
        
        SmartDashboard.putNumber("Pult Encoder value", encoderCatapult.getAverageVoltage());
        SmartDashboard.putNumber("Kicker Encoder value", encoderForklift.getAverageVoltage());
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
