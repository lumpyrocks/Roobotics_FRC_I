package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dorian
 */
public class RooAutonomous {
    
    private static RooAutonomous ra = null;
    public static RooAutonomous getInstance() {
        if (ra==null) {
            ra = new RooAutonomous();
        }
        return ra;
    }
    
    RooDriveTrain rdt;
    RooCatapult pult;
    RooScoreAGoal rsg;
    
    private final double speed = .5;
    
    
    
    public RooAutonomous() {
        this.rdt = RooDriveTrain.getInstance();
        this.pult = RooCatapult.getInstance();
        this.rsg = RooScoreAGoal.getInstance();
        SmartDashboard.putNumber("Distance from Autonomous Goal", 1);
        SmartDashboard.putNumber("Auton Fwd Time", 6000);
        SmartDashboard.putNumber("Auton Rev Time", 0);
        SmartDashboard.putNumber("Auton Left FWD Speed", .4);
        SmartDashboard.putNumber("Auton Right FWD Speed", .5);
        SmartDashboard.putNumber("Auton Left REV Speed", -.5);
        SmartDashboard.putNumber("Auton Right REV Speed", -.4);
        
    }
    public void doAutonomous (){
        try{  
            rdt.setLeft(SmartDashboard.getNumber("Auton Left FWD Speed"));
            rdt.setRight(SmartDashboard.getNumber("Auton Right FWD Speed"));
            Thread.sleep((long) SmartDashboard.getNumber("Auton Fwd Time"));
            rdt.setLeft(SmartDashboard.getNumber("Auton Left REV Speed"));
            rdt.setRight(SmartDashboard.getNumber("Auton Right REV Speed")) ;
            Thread.sleep((long) SmartDashboard.getNumber("Auton Rev Time"));
            rdt.setBoth(0);
            Thread.sleep(1250);
            //rsg.scoreAHighGoal();
            rsg.pultALowGoal();
           //rwh.HENRY_MUST_BE_KILLED = true;
        }catch (java.lang.InterruptedException e){
            System.err.println("Shoot! SexyAnimals!! The main thread caught an interrupt signal, we're ignoring it (Like a Boss)!");
                    
        }
    }
    /*
    public void doAutonomousSonic(){
        try{   
        RooAutoRangerSensorPair us = RooAutoRangerSensorPair.getInstance();
        rdt.setBoth(speed);
        
        /*while(us.voltsToInches(us.getDistance())> SmartDashboard.getNumber("Distance from Automonous Goal")){
                Thread.sleep(10);
        }
        rdt.setBoth(0);
        Thread.sleep(10);
        pult.launch(true);

        }
        catch(java.lang.InterruptedException e){
            
        }
    }*/
}
