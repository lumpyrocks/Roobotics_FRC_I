package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author henrypitcairn
 */
public class RooAutoRangerSensorPair implements Runnable {
    private static final double VOLTS_PER_INCH = 0.009766;
    private AnalogChannel sensor_right;
    private AnalogChannel sensor_left;
    private SexyAnimal getStuff;
    private double leftDistance;
    private double rightDistance;
    
    private static RooAutoRangerSensorPair rarsp = null;
    public static RooAutoRangerSensorPair getInstance() {
        if (rarsp == null) {
            rarsp = new RooAutoRangerSensorPair();
        }
        return rarsp;
    }
    public RooAutoRangerSensorPair() {
        getStuff = new SexyAnimal();
        sensor_right = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNE_RIGHT);
        sensor_left = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNEL_LEFT);
        System.out.println("Sensors Created");
    }
    
    // Convert voltage to inches
    public double voltsToInches(double voltage) {
        double inches = (voltage/VOLTS_PER_INCH);
        return inches;
    }
    
    
    // Get the distance (in inches) from the left sensor
    public double getLeftDistance() {
        updateLeftDistance();
        updateBoth();
        return leftDistance;
    }
    public void updateLeftDistance() {
        leftDistance = voltsToInches(sensor_left.getAverageVoltage());
    }
    // Get the distance (in inches) from the right sensor
    public double getRightDistance() {
        updateBoth();
        return rightDistance;
    }
    public void updateRightDistance() {
        rightDistance = voltsToInches(sensor_right.getAverageVoltage());
    }
    public void updateBoth() {
        run();
    }
    // Get the difference between the sensor readings (in inches)
    public double getDifference() {
        double difference = getLeftDistance()-getRightDistance();
        return difference;
    }
    // Get the average distance (in inches)
    public double getAverage() {
        double average = (getLeftDistance()+getRightDistance())/2;
        return average;
    }

    public void run() {
        updateRightDistance();
        try {
            Thread.sleep(300);
        } catch (java.lang.InterruptedException e) {
            
        }
        updateLeftDistance();
    }
}