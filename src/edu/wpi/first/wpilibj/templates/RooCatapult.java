/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    private RooForkLift fl;
    
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldNow;
    private boolean safetyButtonHeldNow;
    private boolean safetyButtonHeldLastIteration;
    
    public RooCatapult(){ 
        motors = new RooCatapultMotorPair(false);
        this.joystick = RooJoystick.getInstance();
        this.fl = RooForkLift.getInstance();
        buttonHeldLastIteration = false;
        buttonHeldNow = false;
        safetyButtonHeldNow = false;
        SmartDashboard.putNumber("Catapult Power", 1);
        SmartDashboard.putNumber("Catapult Time", 400);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_DURATION_BEFORE_LAUNCH, 800);
    }
    
    public void periodic(){
        if (buttonHeldNow == true && buttonHeldLastIteration == false && safetyButtonHeldNow == true){
            launch(true);
        }
        buttonHeldLastIteration = buttonHeldNow;
        buttonHeldNow = joystick.getRawButton(RobotMap.LAUNCH_BUTTON);
        safetyButtonHeldLastIteration = safetyButtonHeldNow;
        safetyButtonHeldNow = joystick.getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON);
        
    }
    
    public void launch( boolean lowerForklift){
        if (lowerForklift == true){
            makeSureForkLiftIsDown ();
        }
        flatTimerLaunch();
    }
    
    private void makeSureForkLiftIsDown (){
        try{
            fl.setSpeed(-1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT));
            Thread.sleep ((long) SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_DURATION_BEFORE_LAUNCH));
        }catch (java.lang.InterruptedException e){
            
        }
        fl.setSpeed(0.0);
        
    }
    private void flatTimerLaunch (){
        //Timer-Based, flat-speed Launch Function, bare minimum
        try{
            motors.setSpeed(SmartDashboard.getNumber("Catapult Power"));
            Thread.sleep((long)SmartDashboard.getNumber("Catapult Time"));
            motors.setSpeed(0);
        } catch(java.lang.InterruptedException e){
            
        }
        motors.setSpeed(0);
    }
    
}
