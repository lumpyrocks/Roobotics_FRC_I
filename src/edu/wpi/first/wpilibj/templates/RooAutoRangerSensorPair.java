package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author henrypitcairn
 */
public class RooAutoRangerSensorPair {
    private static final double VOLTS_PER_INCH = 0.009766;
    private Ultrasonic sensor;
    private SexyAnimal getStuff;
    private double distance;
    private DigitalInput sensorInput;
    private AnalogChannel left;
    private DigitalOutput ping;
    private static RooAutoRangerSensorPair rarsp = null;
    public static RooAutoRangerSensorPair getInstance() {
        if (rarsp == null) {
            rarsp = new RooAutoRangerSensorPair();
        }
        return rarsp;
    }
    private RooAutoRangerSensorPair() {
        getStuff = new SexyAnimal();
        left = new AnalogChannel(5);
        ping = new DigitalOutput(14);
    }
    
     //Convert voltage to inches
    public double voltsToInches(double voltage) {
        double inches = (voltage/VOLTS_PER_INCH);
        return inches;
    }
    
    
    // Get the distance (in inches) from the left sensor
    //public double getLeftDistance() {
      //  updateLeftDistance();
        //updateBoth();
        //return leftDistance;
    //}
    //public void updateLeftDistance() {
        //leftDistance = sensor_left.getRangeInches();
    //}
    // Get the distance (in inches) from the right sensor
    public double getDistance() {
        distance = left.getVoltage();
        return distance;
   }
   // public void updateDistance() {
   //     distance = left.getAverageVoltage();
   // }
    //public void updateBoth() {
      //  run();
    //}
    // Get the difference between the sensor readings (in inches)

    // Get the average distance (in inches)
 

    /*public void run() {
        updateDistance();
        try {
            Thread.sleep(300);
        } catch (java.lang.InterruptedException e) {
            
      */ }
    
