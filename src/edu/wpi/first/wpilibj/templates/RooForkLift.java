package edu.wpi.first.wpilibj.templates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
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
    
    DigitalInput dInput; 
    
    private double speed;
    
    //TODO: Figure this shiz out
    private final double startingUpSpeed = .7;
    private final double startingDownSpeed = .18;
    
    public RooForkLift (Joystick joystick){
        motor = new Victor (RobotMap.FORKLIFT_MOTOR_CHANNEL);
        dInput = new DigitalInput(RobotMap.LIMIT_SWITCH_FORKLIFT_CHANNEL);
        this.joystick = joystick;
        System.out.println("Water you docking aboat? The Forklift has been constructed! And I should buy a boat. To put my forklift in.");
        System.out.println("Damn we have some wierd debug statements.");
        System.out.println("LETS GET READY TO DROP SOME BONES ON THEM!!!!!!");
        
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
        
    }
    
    public void autoPickup(){
        if(dInput.get() == true && joystick.getRawButton(RobotMap.AUTO_PICKUP_SAFETY) == true){
            motor.set(SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT));
            motor.set(SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT));
        }
    }
    
    public void periodic (){
        
        //Pretty Simple, set speed to the speed set in the dashboard according to which button is pressed.
      
//        if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP) || joystick.getRawButton(RobotMap.JOYSTICK_AS_FORKLIFT)){
//            if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_UP)) {
//                speed = SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
//            }
//            else {
//                speed = -1 * joystick.getY();
//            }
//        }else if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_DOWN) || joystick.getRawButton(RobotMap.JOYSTICK_AS_FORKLIFT)){
//            if (joystick.getRawButton(RobotMap.JOG_FORKLIFT_DOWN)) {
//                speed = -1 * SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
//            }
//            else {
//                speed = -1 * joystick.getY();
//            }
//        } else{
            speed = -1 * joystick.getRawAxis(5);
//        }
        setSpeed (speed);
        autoPickup();
    }
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}
