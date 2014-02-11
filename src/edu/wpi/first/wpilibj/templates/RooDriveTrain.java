/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author Dorian
 */
public class RooDriveTrain {
    
     private final int RIGHT1;
     private final int LEFT1;
     
     private RooJoystick joystick;
     
     private double speed;
     private double rightness;
     //Left and Right PWMs, Roo- signifies that they'll be out own class extending the Kit Talon Class
     //Although there are two motors on eitherside, working under the assumption that they're going to be using a PWM cable Splitter
     private Talon rightPWM1;

     private Talon leftPWM1;
     
     private boolean stop;
     
     private final String invertDriveDS = "Inverted Drive?";
    
    public RooDriveTrain (RooJoystick joystick, int rightPWMChannel, int leftPWMChannel){
        //joystick will be provided by the instantiating class, 
        //the idea is to have a signle Joystick that's running throughout all of the code
        this.joystick = joystick;
        
        // A note about PWM channels, PWMs on the right should always be in ODD PWM channels, on the left in EVEN PWM channels
        this.RIGHT1 = rightPWMChannel;
        this.LEFT1 = leftPWMChannel;
        
        rightPWM1 = new Talon (RIGHT1);
        leftPWM1 = new Talon (LEFT1);
        
        stop = false;
        SmartDashboard.putBoolean(invertDriveDS, false);
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
        //therefore, when stop is pressed, we specifically set the speed to 0
        speed = joystick.rooGetY();
        rightness = joystick.rooGetX();
        
        double cubedSpeed = speed * speed * speed;
        double cubedRightness = rightness * rightness * rightness;
        //Set the speeds of the motors according to Speed
        setRight(speed+rightness);
        setLeft(speed-rightness);
        
        //The following two lines have been commented out until we can get the Bot to move Foreward and Back according to Joystick
        //setRight(speed-joystick.getX());
        //setLeft(speed+joystick.getX());
    }
    public void setLeft(double newSpeed) {
        //inverts the output of the motor given that the inverted speed is checked out
        if (SmartDashboard.getBoolean(invertDriveDS) == true){
            leftPWM1.set(-newSpeed);
        }else{
            leftPWM1.set(newSpeed);
        }
    }
    public void setRight(double newSpeed) {
        //inverts the output of the motor given that the inverted speed is checked out
        if (SmartDashboard.getBoolean(invertDriveDS) == true){
            rightPWM1.set(newSpeed);
        }else{
            rightPWM1.set(-newSpeed);
        }
    }
    public void stop() {
        stop = true;
    }
    public void testRight() {
        setRight(1);
    }
}
