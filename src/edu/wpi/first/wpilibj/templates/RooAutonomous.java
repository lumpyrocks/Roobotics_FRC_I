package edu.wpi.first.wpilibj.templates;

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
    RooDriveTrain rdt;
    RooCatapult pult;
    
    private final double speed = 1.0;
    
    public RooAutonomous (RooDriveTrain rdt, RooCatapult pult){
        this.rdt = rdt;
        this.pult = pult;
    }
    
    public void doAutonomous (){
        try{
            pult.launch();  
            rdt.setBoth(speed);
            Thread.sleep(1000);
            rdt.setBoth(0);
        }catch (java.lang.InterruptedException e){
            
        }
    }
}
