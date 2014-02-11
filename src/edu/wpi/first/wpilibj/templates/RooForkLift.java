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
    
    public RooForkLift (Joystick joystick){
        motor = new Victor (Robotmap.FORKLIFT_MOTOR_CHANNEL);
        
        
    }
    
    public void periodic (){
        
    }
}
