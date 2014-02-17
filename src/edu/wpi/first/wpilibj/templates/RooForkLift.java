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
    
    private static RooForkLift rfl = null;
    
    public static RooForkLift getInstance() {
        if (rfl==null) {
             rfl = new RooForkLift(RooJoystick.getInstance());
         }
         return rfl;
     }
    
    
    Joystick joystick;
    
    Victor motor;
    
    private double speed;
    
    //TODO: Figure this shiz out
    private final double startingUpSpeed = .7;
    private final double startingDownSpeed = .18;
    
    public RooForkLift (Joystick joystick){
        motor = new Victor (RobotMap.FORKLIFT_MOTOR_CHANNEL);
        this.joystick = joystick;
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
        
    }
    
    public void periodic (){
        
        //Pretty Simple, set speed to the speed set in the dashboard according to which button is pressed.
      
        if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP) || joystick.getRawButton(RobotMap.JOYSTICK_AS_FORKLIFT)){
            if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP)) {
                System.out.println("FL JogDown");
                speed = SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
            }
            else {
                speed = -1 * joystick.getY();
            }
        }else if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_DOWN) || joystick.getRawButton(RobotMap.JOYSTICK_AS_FORKLIFT)){
            if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP)) {
                System.out.println("FL JogUp");
                speed = -1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
            }
            else {
                speed = -1 * joystick.getY();
            }
        } else{
            speed = 0;
        }
        setSpeed (speed);
    }
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}
