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
    
    private final double speed = 1.0;
    
    public RooAutonomous (RooDriveTrain rdt, RooCatapult pult){
        this.rdt = rdt;
        this.pult = pult;
        SmartDashboard.putNumber("Distance from Autonomous Goal", 1);
       
    }
    
    public RooAutonomous() {
        this.rdt = RooDriveTrain.getInstance();
        this.pult = RooCatapult.getInstance();
        this.rsg = RooScoreAGoal.getInstance();
    }
    
    public void doAutonomous (){
        try{  
            rdt.setBoth(speed);
            Thread.sleep(5000);
            rdt.setBoth(0);
            rsg.scoreAHighGoal();
            
        }catch (java.lang.InterruptedException e){
            
        }
    }
    
    public void doAutonomousSonic(){
        try{   
        RooAutoRangerSensorPair us = RooAutoRangerSensorPair.getInstance();
        rdt.setBoth(speed);
        while(us.voltsToInches(us.getAverage()) > SmartDashboard.getNumber("Distance from Automonous Goal")){
                Thread.sleep(10);
        }
        rdt.setBoth(0);
        Thread.sleep(10);
        pult.launch(true);

        }
        catch(java.lang.InterruptedException e){
            
        }
    }
}
