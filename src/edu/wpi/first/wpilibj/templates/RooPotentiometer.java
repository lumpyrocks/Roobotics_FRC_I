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
public class RooPotentiometer {
    private AnalogChannel pot;
    
    public void stuffThatIDontKnowHowToDo(){
        pot = new AnalogChannel(3);
      SmartDashboard.putNumber("POTENTIOMETER VALUE", pot.getAverageVoltage()); 
      
    }
}
