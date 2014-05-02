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
    private final double startingUpSpeed = 1;
    private final double startingDownSpeed = .18;
    
    private boolean buttonHeldNow;
    private boolean buttonHeldLastTime;
    private static RooDriveTrain rdt = RooDriveTrain.getInstance();
    private static RooForkliftPotentiometer rflp = RooForkliftPotentiometer.getInstance();
    
    
    public RooForkLift (Joystick joystick){
        motor = new Victor (RobotMap.FORKLIFT_MOTOR_CHANNEL);
        dInput = new DigitalInput(RobotMap.LIMIT_SWITCH_FORKLIFT_CHANNEL);
        this.joystick = joystick;
        
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_DOWN_SPEED_CONSTANT, startingDownSpeed);
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT, startingUpSpeed);
        
        buttonHeldNow = false;
        buttonHeldLastTime = false;
        SmartDashboard.putNumber("ForkLift Pot Angle", 90);
        
    }
    
    public void autoPickup(){
        if(dInput.get() == true && joystick.getRawButton(RobotMap.AUTO_PICKUP_SAFETY) == true){
            motor.set(SmartDashboard.getNumber(RobotMap.SMARTDASHBOARD_FORKLIFT_UP_SPEED_CONSTANT));
        }
    }
    
    public void autoPickupTwo(){
        if(buttonHeldNow == true && buttonHeldLastTime == false && joystick.getRawButton(1)){
            rfl.setSpeed(1);
            rdt.setBoth(0);
            for(int i = 0; i <=200 && rflp.getAngle() <= SmartDashboard.getNumber("ForkLift Pot Angle"); i++ ) {
                try{
                    Thread.sleep(10);
                }
                catch(java.lang.InterruptedException e){
                    
                }
            }
            rfl.setSpeed(0);
            //while(rflp.getAngle() >= SmartDashboard.getNumber("ForkLift Pot Angle")){
              // try{
                //   Thread.sleep(10);
               //}
               //catch(java.lang.InterruptedException e){
                   
               //}
           // }
             //rflp.getAngle();
            
            
        }
        buttonHeldLastTime = buttonHeldNow;
        buttonHeldNow = dInput.get();
        
        
        
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
        autoPickupTwo();
    }
    
    public void setSpeed (double newSpeed){
        motor.set(newSpeed);
    }
}
