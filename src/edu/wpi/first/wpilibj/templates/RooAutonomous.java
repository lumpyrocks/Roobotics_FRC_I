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
    
    private static RooAutonomous ra = null;
    public static RooAutonomous getInstance() {
        if (ra==null) {
            ra = new RooAutonomous();
        }
        return ra;
    }
    
    RooDriveTrain rdt;
    RooCatapult pult;
    
    private final double speed = 1.0;
    
    public RooAutonomous (RooDriveTrain rdt, RooCatapult pult){
        this.rdt = rdt;
        this.pult = pult;
    }
    
    public RooAutonomous() {
        this.rdt = RooDriveTrain.getInstance();
        this.pult = RooCatapult.getInstance();
    }
    
    public void doAutonomous (){
        try{
            pult.launch(true);  
            rdt.setBoth(speed);
            Thread.sleep(1000);
            rdt.setBoth(0);
        }catch (java.lang.InterruptedException e){
            
        }
    }
}
