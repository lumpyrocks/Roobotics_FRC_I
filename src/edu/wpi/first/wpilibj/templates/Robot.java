/*----------------------------------------------------------------------------*/
/* Copyright (c) Henry Pitcairn 2014. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by Henry Pitcairn teams. The code   */
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
    RooCatapultPotentiometer pultPot;
    RooForkliftPotentiometer flPot;
    RooCatapult pult;
    RooKicker kicker;
    RooCosmetics cosmo;
    RooAutoRanger ranger;
    RooAutonomous auton;
    RooWreakHavoc rwh;
    RooScoreAGoal rsg;
    AnalogChannel pot;

    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = RooJoystick.getInstance();
        rdt = RooDriveTrain.getInstance();
        fl = RooForkLift.getInstance();
        pultPot = RooCatapultPotentiometer.getInstance();
        flPot = RooForkliftPotentiometer.getInstance();
        pult = RooCatapult.getInstance();
        kicker = RooKicker.getInstance();
        cosmo = RooCosmetics.getInstance();
        auton = RooAutonomous.getInstance();
        ranger = RooAutoRanger.getInstance();
        rwh = new RooWreakHavoc();
        rsg = RooScoreAGoal.getInstance();
        
        //encoderCatapult.start();
    }

    
    public void autonomousInit (){
        cosmo.updateLights();
        auton.doAutonomous();
        
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
    }

    public void teleopInit () {
        cosmo.updateLights();
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
        
        
        SmartDashboard.putNumber("PULT POTENTIOMETER VALUE", pultPot.getVoltage());
        SmartDashboard.putNumber("PULT POTENTIOMETER ANGLE", pultPot.getAngle());
        
        SmartDashboard.putNumber("LIFT POTENTIOMETER VALUE", flPot.getVoltage());
        SmartDashboard.putNumber("LIFT POTENTIOMETER ANGLE", flPot.getAngle());
        
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
