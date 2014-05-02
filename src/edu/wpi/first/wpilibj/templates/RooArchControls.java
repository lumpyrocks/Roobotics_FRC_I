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
    
    private static RooArchControls arch = null;
    
    private double downHeldNow = 0;
    private double downHeldLastTime = 0;
    private double upHeldNow = 0;
    private double upHeldLastTime = 0;
    
    public static RooArchControls getInstance() {
        if (arch==null) {
             arch = new RooArchControls();
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
        if (downHeldNow == -1 && downHeldLastTime == 0){
            bringArchDown();
        }
        downHeldLastTime = downHeldNow;
        downHeldNow = joystick.getRawAxis(6);
    }
    
    public void bringArchDown (){
        brush.setWheelsIn();
    }
    
    public void checkForUp(){
        if (upHeldNow == 1 && upHeldLastTime == 0){
            bringArchUp();
        }
        upHeldLastTime = upHeldNow;
        upHeldNow = joystick.getRawAxis(6);
    }
    
    public void bringArchUp(){
        brush.setWheelsOut();
    }
    
    
}
