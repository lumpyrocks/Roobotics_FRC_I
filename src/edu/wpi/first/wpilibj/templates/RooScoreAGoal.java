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
    
    private RooKicker kicker;
    private RooForkLift fl;
    private RooCatapult pult;
    private RooDriveTrain rdt;
    
    private RooScoreAGoal (){
        kicker = RooKicker.getInstance();
        fl = RooForkLift.getInstance();
        pult = RooCatapult.getInstance();
        rdt = RooDriveTrain.getInstance();
    }
    public void scoreALowGoal(){
        try{
            rdt.setBoth(-1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Backup Stop Time"));
            rdt.setBoth(0.0);
            
            fl.setSpeed(-1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Forklift Down Stop Time"));
            fl.setSpeed(0.0);
            
            kicker.setSpeed(1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Kicker Up Stop Time"));
            kicker.setSpeed(0.0);
            
            kicker.setSpeed(-1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Kicker Down Stop Time"));
            kicker.setSpeed(0);
            
            fl.setSpeed(1.0);
            Thread.sleep((long)SmartDashboard.getNumber("Forklift Up Stop Time"));
            fl.setSpeed(0);
        }
        catch(java.lang.InterruptedException e){
            
        }
    }
}
