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
    private RooDriveTrain rdt;
    private RooForkLift fl;
    private RooCatapultPotentiometer pultPot;
    
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldNow;
    private boolean safetyButtonHeldNow;
    private boolean potOverMaxValue;
    
    public RooCatapult(){ 
        motors = new RooCatapultMotorPair(false);
        this.joystick = RooJoystick.getInstance();
        rdt = RooDriveTrain.getInstance();
        this.fl = RooForkLift.getInstance();
        buttonHeldLastIteration = false;
        buttonHeldNow = false;
        safetyButtonHeldNow = false;
        pultPot = RooCatapultPotentiometer.getInstance();
        SmartDashboard.putNumber("Catapult Power", 1);
        SmartDashboard.putNumber("Catapult Time", 340);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_DURATION_BEFORE_LAUNCH, 800);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_PULTPOT_MAX_ANGLE, 157);
        SmartDashboard.putBoolean("TEST POT TOO HIGH", false);
        updatePotOverMaxValue();
    }
    
    public void periodic(){
        updatePotOverMaxValue();
        if (buttonHeldNow == true && buttonHeldLastIteration == false && joystick.getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON) == true ){
            launch(true);
        }
        buttonHeldLastIteration = buttonHeldNow;
        buttonHeldNow = joystick.getRawButton(RobotMap.LAUNCH_BUTTON);
    }
    
    public void launch( boolean lowerForklift){
        rdt.setBoth(0);
        if (lowerForklift == true){
            makeSureForkLiftIsDown ();
        }
        potLaunch();
        //flatTimerLaunch();
    }
    
    private void makeSureForkLiftIsDown (){
        try{
            fl.setSpeed(-1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT));
            Thread.sleep ((long) SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_DURATION_BEFORE_LAUNCH));
        }catch (java.lang.InterruptedException e){
            
        }
        fl.setSpeed(0.0);
        
    }
    
    private void updatePotOverMaxValue (){
        potOverMaxValue = (pultPot.getAngle() >= SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_PULTPOT_MAX_ANGLE));
       SmartDashboard.putBoolean("TEST POT TOO HIGH", potOverMaxValue);
    }
    
    private void potLaunch (){
        //For loop to check when pot goes but also as a way of making sure that 
       motors.setSpeed(SmartDashboard.getNumber("Catapult Power"));
        for (int i = 0; (i <= SmartDashboard.getNumber("Catapult Time")/10) && !potOverMaxValue; i++){
            updatePotOverMaxValue();
            try{
                Thread.sleep(10);
            }
            catch (InterruptedException e){
                
            }
            
        }
        motors.setSpeed(0);
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
