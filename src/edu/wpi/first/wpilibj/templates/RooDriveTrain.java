/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author Dorian
 */
public class RooDriveTrain {
    
     private RooJoystick joystick;
     private AnalogChannel ultraSonicRight;
     private AnalogChannel ultraSonicLeft;
     
     private double speed;
     private double rightness;
     //Left and Right PWMs, Roo- signifies that they'll be out own class extending the Kit Talon Class
     //Although there are two motors on eitherside, working under the assumption that they're going to be using a PWM cable Splitter
     private Talon rightPWM;

     private Talon leftPWM;
     
     private boolean stop;
     
     private final String invertDriveDS = "Inverted Drive?";
    
    public RooDriveTrain (RooJoystick joystick, AnalogChannel ultraSonicRight, AnalogChannel ultraSonicLeft){
        //joystick will be provided by the instantiating class, 
        //the idea is to have a signle Joystick that's running throughout all of the code
        this.joystick = joystick;
        this.ultraSonicRight = ultraSonicRight;
        this.ultraSonicLeft = ultraSonicLeft;
        
        rightPWM = new Talon (RobotMap.DRIVE_RIGHT_MOTOR_CHANNEL);
        leftPWM = new Talon (RobotMap.DRIVE_LEFT_MOTOR_CHANNEL);
        
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
        joystickDrive ();
        if (joystick.getRawButton(RobotMap.USE_AUTORANGER_TO_CORRECT)){
            useAutoRangersToCorrect ();
        }
        
        
        
        //The following two lines have been commented out until we can get the Bot to move Foreward and Back according to Joystick
        //setRight(speed-joystick.getX());
        //setLeft(speed+joystick.getX());
    }
    
    public void joystickDrive(){
          speed = joystick.rooGetY();
        rightness = joystick.rooGetX();
        
        double cubedSpeed = speed * speed * speed;
        double cubedRightness = rightness * rightness * rightness;
        //Set the speeds of the motors according to Speed
        setRight(speed+rightness);
        setLeft(speed-rightness);
    }
    
    public void useAutoRangersToCorrect (){
        double distanceLeft = ultraSonicLeft.getAverageVoltage();
        double distanceRight = ultraSonicRight.getAverageVoltage();
        double skew = distanceLeft - distanceRight;
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_SKEW_OUTPUT, skew);
        
    }
    
    public void setLeft(double newSpeed) {
        //inverts the output of the motor given that the inverted speed is checked out
        if (SmartDashboard.getBoolean(invertDriveDS) == true){
            leftPWM.set(-newSpeed);
        }else{
            leftPWM.set(newSpeed);
        }
    }
    public void setRight(double newSpeed) {
        //inverts the output of the motor given that the inverted speed is checked out
        if (SmartDashboard.getBoolean(invertDriveDS) == true){
            rightPWM.set(newSpeed);
        }else{
            rightPWM.set(-newSpeed);
        }
    }
    public void stop() {
        stop = true;
    }
    public void testRight() {
        setRight(1);
    }
}
