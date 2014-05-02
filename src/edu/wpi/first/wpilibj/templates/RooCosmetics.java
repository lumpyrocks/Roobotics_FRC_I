/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.Joystick;
/**
 *
 * @author Dorian
 */
public class RooCosmetics {
    
    private static RooCosmetics rc = null;
    public static RooCosmetics getInstance() {
        if (rc==null) {
            rc = new RooCosmetics();
        }
        return rc;
    }
    
    private Solenoid redLEDs;
    private Solenoid greenLEDs;
    private Solenoid blueLEDs;
    private DriverStation ds;
    private boolean flashy;
    private boolean bhl = false;
    
    public RooCosmetics (){
        //A class for all of the sexy parts of our robot
        //using Driverstation to get which alliance the Team is on
        redLEDs = new Solenoid (RobotMap.RED_LED_SOLENOID_CHANNEL);
        greenLEDs = new Solenoid (RobotMap.GREEN_LED_SOLENOID_CHANNEL);
        blueLEDs = new Solenoid (RobotMap.BLUE_LED_SOLENOID_CHANNEL);
        ds = DriverStation.getInstance();
        SmartDashboard.putBoolean(RobotMap.SMARTDASHBOARD_LED_TOGGLE, true);
        SmartDashboard.putBoolean("RED?", true);
        SmartDashboard.putBoolean("BLUE?", true);
        SmartDashboard.putBoolean("GREEN?", true);
        
    }
    
    public void updateLights(){
        if (!SmartDashboard.getBoolean(RobotMap.SMARTDASHBOARD_LED_TOGGLE)){
            //green LEDs are reversed, so turning them true will turn them off
            greenLEDs.set (true);
            redLEDs.set (false);
            blueLEDs.set (false);
        }else{

//            if (RooJoystick.getInstance().getRawButton(RobotMap.ONE_BUTTON_KICK) && RooJoystick.getInstance().getRawButton(RobotMap.CATAPULT_SAFETY_BUTTON) && !bhl) {
//                if (flashy) flashy=false;
//                if (!flashy) flashy=true;
//            }
//            if (RooJoystick.getInstance().getRawButton(RobotMap.ONE_BUTTON_KICK)) { bhl = true; } else { bhl = false; }
//            
//            if (flashy) {
//                flashy();
//            } else {
                setLEDsToAllianceColors ();
//            }
            
        }
//        if ()
    }
    public void flashy() {
        if (blueLEDs.get()) {
            blueLEDs.set(false);
            redLEDs.set(true);
        } else if (redLEDs.get()) {
           redLEDs.set(false);
           blueLEDs.set(true);
        }
    }
    public void setGreen(){
        //ledStrip.set(SmartDashboard.getBoolean(RobotMap.SMARTDASHBOARD_LED_TOGGLE));
        redLEDs.set(false);
        greenLEDs.set(true);
        System.out.println("================================================================================");
        System.out.println("Set Green");
        System.out.println("===============================================================================");
        blueLEDs.set(false);
    }
    
    private void DELETEMEPLEASE (){
        redLEDs.set(SmartDashboard.getBoolean("RED?"));
        blueLEDs.set(SmartDashboard.getBoolean("BLUE?"));
        greenLEDs.set(SmartDashboard.getBoolean("GREEN?"));
    }
    private void setLEDsToAllianceColors (){
        //Should set the LEDs to Red if alliance is Red, BLue if blue, and green if neither.
        Alliance color = ds.getAlliance();
        switch (color.value){
            case Alliance.kRed_val :    redLEDs.set(true);
                                        greenLEDs.set(true);
                                        blueLEDs.set(false);
                                        break;
            case Alliance.kBlue_val :   redLEDs.set(false);
                                        greenLEDs.set(true);
                                        blueLEDs.set(true);
                                        break;
            default :                   redLEDs.set(false);
                                        greenLEDs.set(false);
                                        blueLEDs.set(false);
                                        break;
        }
    }
}
