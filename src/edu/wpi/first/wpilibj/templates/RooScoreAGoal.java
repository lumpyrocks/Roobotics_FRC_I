/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author Dorian
 */
public class RooScoreAGoal {
    
    private static RooScoreAGoal rsg;
    public static RooScoreAGoal getInstance (){
        if (rsg == null){
            rsg = new RooScoreAGoal ();
        }
        return rsg;
    }
    
    private RooJoystick joystick;
    private RooKicker kicker;
    private RooForkLift fl;
    private RooCatapult pult;
    private RooDriveTrain rdt;
    private boolean buttonHeldNow;
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldAtTheMoment;
    private boolean buttonHeldLastTime;
    
    private RooScoreAGoal (){
        joystick = RooJoystick.getInstance();
        kicker = RooKicker.getInstance();
        fl = RooForkLift.getInstance();
        pult = RooCatapult.getInstance();
        rdt = RooDriveTrain.getInstance();
        SmartDashboard.putNumber("Backup Stop Time", 400);
        SmartDashboard.putNumber("Forklift Down Stop Time", 500);
        SmartDashboard.putNumber("Kicker Up Stop Time",500);
//        System.out.println("Putting stop time on smartdashboard");
        SmartDashboard.putNumber("Kicker Down Stop Time",500);
//        System.out.println("Getting stop time from smartdashboard");
        SmartDashboard.putNumber("Forklift Up Stop Time", 500);
//        System.out.println("Got stop time from smartdashboard");
        SmartDashboard.putNumber("Slow Launch Multiplier (>1)", 1.9);
        buttonHeldAtTheMoment = false;
        buttonHeldLastTime = false;
    }
    
    public void periodic(){
        if (buttonHeldNow == true && buttonHeldLastIteration == false && !joystick.getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON)){
            scoreALowGoal();
            System.out.println("Dogman");
        }else if (buttonHeldNow == true && buttonHeldLastIteration == false && joystick.getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON)){
            pultALowGoal();
            System.out.println("Catman");
        }
        scoreAHighGoal();
        buttonHeldLastIteration = buttonHeldNow;
        buttonHeldNow = joystick.getRawButton(RobotMap.SCORE_A_LOW_GOAL);
        
    }
    public void scoreAHighGoal (){
      if (buttonHeldAtTheMoment == true && buttonHeldLastTime == false && joystick.getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON) == true){
      try{   
        rdt.setLeft(-.5);
        rdt.setRight(-.4) ;
        
        Thread.sleep((long) SmartDashboard.getNumber("Auton Rev Time"));
        rdt.setBoth(0);
        Thread.sleep(200);
        //rsg.scoreAHighGoal();
        pult.launch(true);
        //rwh.HENRY_MUST_BE_KILLED = true;
        }
        catch(java.lang.InterruptedException e){   
        } 
      buttonHeldLastTime = buttonHeldAtTheMoment;
      buttonHeldAtTheMoment = joystick.getRawButton(RobotMap.SCORE_HIGH_GOAL);
      }
    }
    
    public void scoreALowGoal(){
        try{
            rdt.setRight(.5);
            rdt.setLeft(.4);
            Thread.sleep((long)SmartDashboard.getNumber("Backup Stop Time"));
            rdt.setBoth(0.0);
            
            fl.setSpeed(-1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Forklift Down Stop Time"));
            fl.setSpeed(0.0);
            
            kicker.setSpeed(-1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Kicker Up Stop Time"));
            kicker.setSpeed(1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Kicker Down Stop Time"));
            kicker.setSpeed(0);
            
            fl.setSpeed(1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Forklift Up Stop Time"));
            fl.setSpeed(0);
        }
        catch(java.lang.InterruptedException e){
            
        }
    }

    public void pultALowGoal() {
        double defaultPower = SmartDashboard.getNumber("Catapult Power");
        double defaultTime = SmartDashboard.getNumber("Catapult Time");
        SmartDashboard.putNumber("Catapult Power", defaultPower/SmartDashboard.getNumber("Slow Launch Multiplier (>1)"));
        SmartDashboard.putNumber("Catapult Time", defaultTime*SmartDashboard.getNumber("Slow Launch Multiplier (>1)"));
        pult.launch(true);
        SmartDashboard.putNumber("Catapult Power", defaultPower);
        SmartDashboard.putNumber("Catapult Time", defaultTime);
    }
}
