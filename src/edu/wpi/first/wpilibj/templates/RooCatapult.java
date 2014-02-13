/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
/**
 *
 * @author henrypitcairn
 */
public class RooCatapult{
    private RooCatapultMotorPair motors;
    private Joystick joystick;
    
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldNow;
    
    public RooCatapult(Joystick joystick){ 
        motors = new RooCatapultMotorPair(false);
        this.joystick = joystick;
        buttonHeldLastIteration = false;
        buttonHeldNow = false;
    }
    
    public void periodic(){
        if (buttonHeldNow == true && buttonHeldLastIteration == false){
            launch();
        }
        buttonHeldLastIteration = buttonHeldNow;
        buttonHeldNow = joystick.getRawButton(RobotMap.LAUNCH_BUTTON);
    }
    
    public void launch(){
        try{
            /*for(double i = 0; i<=1.0; i+= 0.1){
                Thread.sleep(3);
                motors.setSpeed(i);
            }*/
            motors.setSpeed(1);
            Thread.sleep(100);
            motors.setSpeed(-1);
            Thread.sleep(100);
            motors.setSpeed(0);
            /*for(double i = 1; i>=0; i = i - .1){
                Thread.sleep(3);
                motors.setSpeed(-i);
            }*/
        } catch(java.lang.InterruptedException e){
            
        }
        motors.setSpeed(0);
    }
}
