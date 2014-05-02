/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Anna
 */
public class RooCatapultPotentiometer {
    private static final double DEGREES_PER_VOLT = 62.8;
    private AnalogChannel pot;
    
    private static RooCatapultPotentiometer pultPot = null;
    public static RooCatapultPotentiometer getInstance() {
        if (pultPot==null) {
            pultPot = new RooCatapultPotentiometer();
        }
        return pultPot;
    }
    
    public RooCatapultPotentiometer(){
        pot = new AnalogChannel(RobotMap.POTENTIOMETER_CATAPULT);
        SmartDashboard.putNumber("POTENTIOMETER VALUE", pot.getAverageVoltage()); 
    }
    
    public double getVoltage(){
        return pot.getAverageVoltage();
    }
    
    public double getAngle(){
        return getVoltage() * RooCatapultPotentiometer.DEGREES_PER_VOLT;
    }
}
