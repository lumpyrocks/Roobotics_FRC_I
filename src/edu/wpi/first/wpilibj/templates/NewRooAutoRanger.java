/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
/**
 *
 * @author Dorian
 */
public class NewRooAutoRanger {
    
    /**
     * @param args the command line arguments
     */
    public static NewRooAutoRanger nrar = null;
    public static NewRooAutoRanger getInstance() {
        if (nrar==null) {
            nrar = new NewRooAutoRanger();
        }
        return nrar;
    }
    
    private AnalogChannel input;
    
    public NewRooAutoRanger() {
        input = new AnalogChannel(RobotMap.AUTORANGER_CHANNEL); //Autoranger Channel is 5
    }
    public double getVoltage() {
        return input.getAverageVoltage();
    }
    public double getInches() {
        return voltsToInches(getVoltage());
    }
    public double voltsToInches(double voltage) {
        return voltage/0.009766;
    }
    public double getADC() {
        return input.getValue();
    }
    public void periodic() {
        SmartDashboard.putNumber("Autoranger Voltage: ", getVoltage());
        SmartDashboard.putNumber("Autoranger Inches: ", getInches());
        SmartDashboard.putNumber("Raw ADC value: ", getADC());
    }
}
