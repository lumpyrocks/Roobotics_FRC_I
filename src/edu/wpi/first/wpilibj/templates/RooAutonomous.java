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
    
    public RooAutonomous (RooDriveTrain rdt, RooCatapult pult){
        this.rdt = rdt;
        this.pult = pult;
    }
    
    public void doAutonomous (){
        pult.launch();
    }
}
