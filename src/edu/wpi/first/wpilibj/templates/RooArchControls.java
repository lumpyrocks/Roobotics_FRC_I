/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Dorian
 */
public class RooArchControls {
    
    RooForkLift lift;
    RooArchMotor brush;
    RooJoystick joystick;
    RooForkliftPotentiometer liftPot;
    
    private static RooArchMotor arch = null;
    
    private boolean downHeldNow = false;
    private boolean downHeldLastTime = false;
    private boolean upHeldNow = false;
    private boolean upHeldLastTime = false;
    
    public static RooArchMotor getInstance() {
        if (arch==null) {
             arch = new RooArchMotor();
         }
         return arch;
     }
    
    public RooArchControls() {
        lift = RooForkLift.getInstance();
        brush = RooArchMotor.getInstance();
        joystick = RooJoystick.getInstance();
        liftPot = RooForkliftPotentiometer.getInstance();
    }
    
    public void checkForBothButtons(){
        checkForDown();
        checkForUp();
    }
    
    public void checkForDown(){
        if (downHeldNow == true && downHeldLastTime == false){
            bringArchDown();
        }
        downHeldLastTime = downHeldNow;
        downHeldNow = joystick.getRawButton(RobotMap.BRING_ARCH_DOWN);
    }
    
    public void bringArchDown (){
        
    }
    
    public void checkForUp(){
        if (upHeldNow == true && upHeldLastTime == false){
            bringArchUp();
        }
        upHeldLastTime = upHeldNow;
        upHeldNow = joystick.getRawButton(RobotMap.BRING_ARCH_UP);
    }
    
    public void bringArchUp(){
        
    }
    
    
}
