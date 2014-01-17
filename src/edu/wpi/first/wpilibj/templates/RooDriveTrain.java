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
     //private final int RIGHT2;
     private final int LEFT1;
     //private final int LEFT2;
     
     private Joystick joystick;
     
     private double speed;
     
     //Left and Right PWMs, Roo- signifies that they'll be out own class extending the Kit Talon Class
     //Although there are two motors on eitherside, working under the assumption that they're going to be using a PWM cable Splitter
     private RooTalon rightPWM1;
     //private RooTalon rightPWM2;
     private RooTalon leftPWM1;
     //private RooTalon leftPWM2;
     
     private boolean stop;
    
    public RooDriveTrain (Joystick joystick, int rightPWMChannel1, int rightPWMChannel2, int leftPWMChannel1, int leftPWMChannel2){
        //joystick will be provided by the instantiating class, 
        //the idea is to have a signle Joystick that's running throughout all of the code
        this.joystick = joystick;
        
        // A note about PWM channels, PWMs on the right should always be in ODD PWM channels, on the left in EVEN PWM channels
        this.RIGHT1 = rightPWMChannel1;
        //this.RIGHT2 = rightPWMChannel2;
        this.LEFT1 = leftPWMChannel1;
        //this.LEFT2 = leftPWMChannel2;
        
        rightPWM1 = new RooTalon (RIGHT1);
        //rightPWM2 = new RooTalon (RIGHT2);
        leftPWM1 = new RooTalon (LEFT1);
        //leftPWM2 = new RooTalon(LEFT2);
        
        stop = false;
    }
    public RooDriveTrain(Joystick joystick) {
        this.RIGHT1 = 3;
        //this.RIGHT2 = 3;
        this.LEFT1 = 4;
        //this.LEFT2 = 4;
        
        rightPWM1 = new RooTalon (RIGHT1);
        //rightPWM2 = new RooTalon (RIGHT2);
        leftPWM1 = new RooTalon (LEFT1);
        //leftPWM2 = new RooTalon(LEFT2);
        
        stop = false;
    }
    
    /**
     * The function called by teleopPeriodic. 
     */
    public void periodic() {
        //In case you didn't see the note in teleopPeriodic:
        //There are to be no loops within teleopPeriodic, and ESPECIALLY not indefinite loops.
        //This is because teleopPeriodic is functionally already a loop
        //therefore any contiuous action or logic (such as setting motors) can happen only once in it
        //And it will still happen 20 times per second.
        
        //Just because we do not set the speed does not mean the speed is not set
        //therefore, when stop is pressed, we specifically set the speed to 0.
        if (stop) {
            //Set
            speed = 0;
        }else{
            speed = joystick.getY();
        }
        
        //Set the speeds of the motors according to Speed
        setRight(speed);
        setLeft(speed);
        //The following two lines have been commented out until we can get the Bot to move Foreward and Back according to Joystick
        //setRight(speed-joystick.getX());
        //setLeft(speed+joystick.getX());
    }
    public void setLeft(double newSpeed) {
        leftPWM1.set(newSpeed);
        //leftPWM2.set(newSpeed);
    }
    public void setRight(double newSpeed) {
        rightPWM1.set(newSpeed);
        //rightPWM2.set(newSpeed);
    }
    public void stop() {
        stop = true;
    }
}
