 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author henrypitcairn
 */

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //Limit Switches
    public static final int LIMIT_SWITCH_FORKLIFT_CHANNEL = 10;
    
    // Drive Subsystem
    // Digital Sidecar PWM outputs
    public static final int DRIVE_LEFT_MOTOR_CHANNEL = 4;
    public static final int DRIVE_RIGHT_MOTOR_CHANNEL = 3;
   
    //Digital IO
    public static final int KICKER_LIMIT_SWITCH = 1;
    public static final int ULTRASONIC_PING_CHANNEL = 14;
    
    // Analog Breakout
    public static final int GYRO_CHANNEL = 1;
    // Driver Station
    public static final int DRIVE_JOYSTICK_PORT = 1;
    // The catapult safety button
    public static final int CATAPULT_SAFETY_BUTTON = 7;
    //Buttons for Joystick, these numbers are temporary
    public static final int BUMP_LEFT_BUTTON = 99; //4;
    public static final int LAUNCH_BUTTON = 8; //1;
    public static final int BUMP_RIGHT_BUTTON = 99; //3;
    public static final int BUMP_FORWARD_BUTTON = 99; // 2;
    public static final int BUMP_REVERSE_BUTTON = 99; //1;
    public static final int ONE_BUTTON_KICK = 3; //9;
    public static final int JOG_FORKLIFT_UP = 99; //11;
    public static final int JOG_FORKLIFT_DOWN = 99; //10;
    public static final int USE_AUTORANGER_TO_CORRECT = 4; //8;
    public static final int JOYSTICK_AS_FORKLIFT = 99;//2;
    public static final int SCORE_A_LOW_GOAL= 2; //4;
    public static final int KICKER_TIMEOUT = 500; //Milliseconds
    public static final int SCORE_HIGH_GOAL = 10;
    public static final int ARCH_MOTOR_SPEED = 1;
    public static final int ARCH_MOTOR_CHANNEL = 1;
    public static final int AUTO_PICKUP_SAFETY = 1;
    
    // Left Bumper and Right bumper used to be the jog Kicker functions but since the arch might take place of the kickers
    //the buttons are now controling the arch
    public static final int JOG_KICKER_UP = 6; //6;
    public static final int JOG_KICKER_DOWN = 5; //7;
    
    
    
////////////////////////////////////////////////////////////////////////////////
    

    
    //potentiometers
    public static final int POTENTIOMETER_CATAPULT = 3;
    public static final int POTENTIOMETER_FORKLIFT = 4;
    public static final int POTENTIOMETER_KICKER = 5;
    
    // Digital Sidecar GPIO outputs
    public static final int RANGE_BEACON_RED_CHANNEL = 1;
    public static final int RANGE_BEACON_YELLOW_CHANNEL = 2;
    public static final int RANGE_BEACON_GREEN_CHANNEL = 3;
    
    public static final int RED_LED_SOLENOID_CHANNEL = 2;
    public static final int BLUE_LED_SOLENOID_CHANNEL = 3;
    public static final int GREEN_LED_SOLENOID_CHANNEL = 1;
////////////////////////////////////////////////////////////////////////////////
    
    // Launcher Subsystem
    // Digital Sidecar PWM outputs
    public static final int LAUNCHER_LEFT_MOTOR_CHANNEL = 6;
    public static final int LAUNCHER_RIGHT_MOTOR_CHANNEL = 5;
//////////////////////////////////////////////////////////////////////////////// 
    
    // Forklift Subsystem
    // Digital Sidecar PWM outputs
    public static final int KICKER_MOTOR_CHANNEL = 7;
    public static final int FORKLIFT_MOTOR_CHANNEL = 8;

////////////////////////////////////////////////////////////////////////////////
    // Keys Used for the Smart Dashboard
    public static final String SMARTDASHBOARD_INVERTED_DRIVE = "Inverted Controls?";
    public static final String SMARTDASHBOARD_AUTORANGER_VALUE = "AutoRanger Value";
    public static final String SMARTDASHBOARD_AUTORANGER_VALUE_INCHES = "AutoRanger Value in Inches";
    public static final String SMARTDASHBOARD_AUTORANGER_AT_DESIRED_VALUE = "In Position?";
    public static final String SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT = "Forklift Up Speed: ";
    public static final String SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT = "Forklift Down Speed: ";
    public static final String SMARTDASHBOARD_KICKER_UP_SPEED_CONSTANT = "Kicker Up Speed: ";
    public static final String SMARTDASHBOARD_KICKER_DOWN_SPEED_CONSTANT = "Kicker Down Speed: ";
    public static final String SMARTDASHBOARD_SKEW_OUTPUT = "Skew: ";
    public static final String SMARTDASHBOARD_LED_TOGGLE = "Alliance LEDs?";
    public static final String SMARTDASHBOARD_FORKLIFT_DOWN_DURATION_BEFORE_LAUNCH = "Forklift pre-launch lower duration";
    public static final String SMARTDASHBOARD_KICKER_TIMEOUT = "Time it takes to put kicker down and up in milliseconds";
    public static final String SMARTDASHBOARD_PULTPOT_MAX_ANGLE = "Pult Max Angle?";
    public static final int AUTORANGER_CHANNEL = 5;
    
    
    
    
}
