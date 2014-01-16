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
    
     private final int RIGHT1;
     private final int RIGHT2;
     private final int LEFT1;
     private final int LEFT2;
     
     private Joystick joystick;
     
     private double speed;
     
     //Left and Right PWMs, Roo- signifies that they'll be out own class extending the Kit Talon Class
     //Although there are two motors on eitherside, working under the assumption that they're going to be using a PWM cable Splitter
     private RooTalon rightPWM1;
     private RooTalon rightPWM2;
     private RooTalon leftPWM1;
     private RooTalon leftPWM2;
     
     private boolean stop;
    
    public RooDriveTrain (Joystick joystick, int rightPWMChannel1, int rightPWMChannel2, int leftPWMChannel1, int leftPWMChannel2){
        //joystick will be provided by the instantiating class, 
        //the idea is to have a signle Joystick that's running throughout all of the code
        this.joystick = joystick;
        
        // A note about PWM channels, PWMs on the right should always be in ODD PWM channels, on the left in EVEN PWM channels
        this.RIGHT1 = rightPWMChannel1;
        this.RIGHT2 = rightPWMChannel2;
        this.LEFT1 = rightPWMChannel1;
        this.LEFT2 = rightPWMChannel2;
        
        rightPWM1 = new RooTalon (RIGHT1);
        rightPWM2 = new RooTalon (RIGHT2);
        leftPWM1 = new RooTalon (LEFT1);
        leftPWM2 = new RooTalon(LEFT2);
        
        stop = false;
    }
    public RooDriveTrain(Joystick joystick) {
        this.RIGHT1 = 1;
        this.RIGHT2 = 3;
        this.LEFT1 = 2;
        this.LEFT2 = 4;
        
        rightPWM1 = new RooTalon (RIGHT1);
        rightPWM2 = new RooTalon (RIGHT2);
        leftPWM1 = new RooTalon (LEFT1);
        leftPWM2 = new RooTalon(LEFT2);
        
        stop = false;
    }
    public void start() {
        while (!stop) {
            speed = joystick.getY();

            rightPWM1.set(speed-1);
            rightPWM2.set(speed-1);

            leftPWM1.set(speed+1);
            leftPWM2.set(speed+1);
        }
    }
    public void stop() {
        stop = true;
    }
}
