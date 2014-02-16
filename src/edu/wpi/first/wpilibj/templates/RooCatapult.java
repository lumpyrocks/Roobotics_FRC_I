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
    
    private static RooCatapult rc = null;
    public static RooCatapult getInstance() {
        if (rc==null) {
            rc = new RooCatapult();
        }
        return rc;
    }
    
    private RooCatapultMotorPair motors;
    private Joystick joystick;
    
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldNow;
    
    public RooCatapult(){ 
        motors = new RooCatapultMotorPair(false);
        this.joystick = RooJoystick.getInstance();
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
        flatTimerLaunch();
    }
    
    
    private void flatTimerLaunch (){
        //Timer-Based, flat-speed Launch Function, bare minimum
        try{
            motors.setSpeed(.25);
            Thread.sleep(1000);
            motors.setSpeed(-.25);
            Thread.sleep(1000);
            motors.setSpeed(0);
        } catch(java.lang.InterruptedException e){
            
        }
        motors.setSpeed(0);
    }
    
}
