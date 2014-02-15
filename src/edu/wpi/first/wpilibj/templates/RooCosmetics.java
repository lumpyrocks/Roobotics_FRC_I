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
/**
 *
 * @author Dorian
 */
public class RooCosmetics {
    
    private Solenoid redLEDs;
    private Solenoid greenLEDs;
    private Solenoid blueLEDs;
    private DriverStation ds;
    
    
    public RooCosmetics (){
        //A class for all of the sexy parts of our robot
        //using Driverstation to get which alliance the Team is on
        redLEDs = new Solenoid (RobotMap.RED_LED_SOLENOID_CHANNEL);
        greenLEDs = new Solenoid (RobotMap.GREEN_LED_SOLENOID_CHANNEL);
        blueLEDs = new Solenoid (RobotMap.BLUE_LED_SOLENOID_CHANNEL);
        ds = DriverStation.getInstance();
        SmartDashboard.putBoolean(RobotMap.SMARTDASHBOARD_LED_TOGGLE, true);
        
    }
    
    public void init(){
        //Happens once at the onset of each seciton of the game (autoninit and teleopinit)
        if (SmartDashboard.getBoolean(RobotMap.SMARTDASHBOARD_LED_TOGGLE) == true){
            setLEDsToAllianceColors ();
        }
    }
    private void setLEDsToAllianceColors (){
        //Should set the LEDs to Red if alliance is Red, BLue if blue, and green if neither.
        Alliance color = ds.getAlliance();
        SmartDashboard.putString("DEBUG TOOL, COLOR = ", color.name);
        switch (color.value){
            case Alliance.kRed_val :    redLEDs.set(true);
                                        greenLEDs.set(false);
                                        blueLEDs.set(false);
                                        break;
            case Alliance.kBlue_val :   redLEDs.set(false);
                                        greenLEDs.set(false);
                                        blueLEDs.set(true);
                                        break;
            default :                   redLEDs.set(false);
                                        greenLEDs.set(true);
                                        blueLEDs.set(false);
                                        break;
        }
    }
}
