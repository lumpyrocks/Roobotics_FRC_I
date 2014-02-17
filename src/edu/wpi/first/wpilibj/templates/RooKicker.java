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
    
    
    private double speed;
    
    //TODO: Figure this shiz out
    private final double startingUpSpeed = .7;
    private final double startingDownSpeed = .5;
    
    public RooKicker (Joystick joystick){
        motor = new Victor (RobotMap.KICKER_MOTOR_CHANNEL);
        this.joystick = joystick;
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed);
        
    }
    public RooKicker (){
        motor = new Victor (RobotMap.KICKER_MOTOR_CHANNEL);
        this.joystick = RooJoystick.getInstance();
        
        limitSwitch = new DigitalInput (RobotMap.KICKER_LIMIT_SWITCH);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed);
        
    }
    
    public void periodic (){
        
        //Pretty Simple, set speed to the speed set in the dashboard according to which button is pressed.
      
        if ((joystick.getRawButton(RobotMap.JOG_KICKER_UP) == true)){
            speed = -1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT, startingUpSpeed);
        }else if (joystick.getRawButton(RobotMap.JOG_KICKER_DOWN)){
            speed = SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT, startingDownSpeed);
        } else{
            speed = 0;
        }
        setSpeed (speed);
    }
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}
