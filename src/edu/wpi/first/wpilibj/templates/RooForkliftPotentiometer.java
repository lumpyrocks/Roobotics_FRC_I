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
public class RooForkliftPotentiometer {
    private static final double DEGREES_PER_VOLT = 62.8;
    private AnalogChannel pot;
    
    private static RooForkliftPotentiometer pultPot = null;
    public static RooForkliftPotentiometer getInstance() {
        if (pultPot==null) {
            pultPot = new RooForkliftPotentiometer();
        }
        return pultPot;
    }
    
    public RooForkliftPotentiometer(){
        pot = new AnalogChannel(RobotMap.POTENTIOMETER_FORKLIFT);
        SmartDashboard.putNumber("POTENTIOMETER VALUE FER FORKLIFT", pot.getAverageVoltage()); 
    }
    
    public double getVoltage(){
        return pot.getAverageVoltage();
    }
    
    public double getAngle(){
        return getVoltage() * RooForkliftPotentiometer.DEGREES_PER_VOLT;
    }
}
