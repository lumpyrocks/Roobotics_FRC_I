/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
/**
 *
 * @author Dorian
 */
public class RooDriveTrain {
    
     private Joystick joystick;
     
     //Left and Right PWMs, Roo- signifies that they'll be out own class extending the Kit Talon Class
     //Although there are two motors on eitherside, working under the assumption that they're going to be using a PWM cable Splitter
     private RooTalon rightPWM;
     private RooTalon leftPWM;
    
    public RooDriveTrain (Joystick joystick, int rightPWMChannel, int leftPWMChannel){
        //joystick will be provided by the instantiating class, 
        //the idea is to have a signle Joystick that's running throughout all of the code
        this.joystick = joystick;
        
        // A note about PWM channels, PWMs on the right should always be in ODD PWM channels, on the left in EVEN PWM channels
        rightPWM = new RooTalon (rightPWMChannel);
        leftPWM = new RooTalon (leftPWMChannel);

    }
    
    
}
