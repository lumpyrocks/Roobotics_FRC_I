/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author henrypitcairn
 */
public class RooCatapult{
    private RooCatapultMotorPair motors;
    
    public RooCatapult(){ 
        motors = new RooCatapultMotorPair(false);
    }
    public void lauch(){
        try{
            for(double i = 0; i<=1.0; i+= 0.1){
                Thread.sleep(3);
                motors.setSpeed(i);
            }
            Thread.sleep(10);
            for(double i = 1; i>=0; i = i - .1){
                Thread.sleep(3);
                motors.setSpeed(i);
            }
        } catch(java.lang.InterruptedException e){
            
        }
        motors.setSpeed(0);
    }
}
