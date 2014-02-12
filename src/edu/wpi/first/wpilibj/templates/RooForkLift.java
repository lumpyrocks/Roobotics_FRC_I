package edu.wpi.first.wpilibj.templates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author Dorian
 */
public class RooForkLift {
    
    Joystick joystick;
    
    Victor motor;
    
    private double speed;
    
    //TODO: Figure this shiz out
    private final double startingUpSpeed = .6;
    private final double startingDownSpeed = .25;
    
    public RooForkLift (Joystick joystick){
        motor = new Victor (RobotMap.FORKLIFT_MOTOR_CHANNEL);
        this.joystick = joystick;
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
        
    }
    
    public void periodic (){
        
        //Pretty Simple, set speed to the speed set in the dashboard according to which button is pressed.
      
        if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP)){
            speed = SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
        }else if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_DOWN)){
            speed = -1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
        } else{
            speed = 0;
        }
        setSpeed (speed);
    }
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}
