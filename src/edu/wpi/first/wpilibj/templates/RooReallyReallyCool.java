/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Dorian what the heck are you doing? STOP with the ridiculously ambigous file names and class names or you
// Will be kicked out from the penial rocks foundation.
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author henrypitcairn
 */
public class RooReallyReallyCool {
    private static RooReallyReallyCool rrrc = null;
    public static RooReallyReallyCool getInstance() {
        if (rrrc == null) {
            rrrc = new RooReallyReallyCool();
        }
        return rrrc;
    }
    
    
    private RooAutoRangerSensorPair sensors;
    private RooDriveTrain rdt;
    public RooReallyReallyCool() {
        sensors = RooAutoRangerSensorPair.getInstance();
        rdt = RooDriveTrain.getInstance();
    }
    
    public void doCoolStuffPeriodic() {
        while(sensors.voltsToInches(sensors.getDistance())<60) {
            rdt.setBoth(0.6);
        }
        rdt.setBoth(-0.4);
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        rdt.setLeft(0.7);
        rdt.setRight(-0.7);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        rdt.setBoth(0.0);
    }
}
