package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 15BenjaminH
 */
public class RooKicker {
    
    private static RooKicker rk = null;
    public static RooKicker getInstance() {
        if (rk==null) {
            rk = new RooKicker();
        }
        return rk;
    }
    
    Joystick joystick;
    
    Victor motor;
    
    DigitalInput limitSwitch;
    
    private boolean buttonHeldLastIteration;
    private boolean buttonHeldNow;
    private boolean isKickable;
    
    private double speed = 250;
    
    //TODO: Figure this shiz out
    private final double startingUpSpeed = .7;
    private final double startingDownSpeed = .65;
    
    public RooKicker (){
        motor = new Victor (RobotMap.KICKER_MOTOR_CHANNEL);
        this.joystick = RooJoystick.getInstance();
        buttonHeldLastIteration = false;
        buttonHeldNow = false;
        limitSwitch = new DigitalInput (RobotMap.KICKER_LIMIT_SWITCH);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_TIMEOUT, 350);
        
    }
    
    public void periodic (){
        
        //Pretty Simple, set speed to the speed set in the dashboard according to which button is pressed.
        kickCommand ();
        if ((joystick.getRawButton(RobotMap.JOG_KICKER_UP) == true)){
            speed = -1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed);
        }else if (joystick.getRawButton(RobotMap.JOG_KICKER_DOWN)){
            speed = SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, startingDownSpeed);
            System.out.println("WE DROP BONES ON 'EM");
        } else{
            speed = 0;
        }
        setSpeed (speed);
        
        //
    }
    public void kickCommand (){
        //checks if the button is pressed so that we can know whether or not to kick
        if (buttonHeldNow == true && buttonHeldLastIteration == false){
            System.out.println("Button is being held!");
            fullKick();
        }
        buttonHeldLastIteration = buttonHeldNow;
        buttonHeldNow = joystick.getRawButton(RobotMap.ONE_BUTTON_KICK);
    }
    
    public void fullKick (){
        //Moves the kicker foreward and back all in one motion
        /*if (isKickable == false){
        }
        else if (isKickable == true && joystick.getRawButton(RobotMap.ONE_BUTTON_KICK) == true) {
            isKickable = false;*/
        setSpeed(-1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed));
        System.out.println("Speed has been set up");
        try{
            Thread.sleep((long) SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_TIMEOUT));
        }catch (java.lang.InterruptedException e){
        }
        setSpeed(SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, -1*startingDownSpeed));
        System.out.println("Speed has been set down");
        try{
            Thread.sleep((long) SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_TIMEOUT));    
        }catch (java.lang.InterruptedException a){
        }
        setSpeed (0);
          //  isKickable = true;    
        //}
    }

        
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}