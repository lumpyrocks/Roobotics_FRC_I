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
public class RooAutoRangerSensorPair {
    private static final double VOLTS_PER_INCH = 0.009766;
    private AnalogChannel sensor_right;
    private AnalogChannel sensor_left;
    public RooAutoRangerSensorPair() {
        sensor_right = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNE_RIGHT);
        sensor_left = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNEL_LEFT);
    }
    
    // Convert voltage to inches
    public double voltsToInches(double voltage) {
        double inches = (voltage/VOLTS_PER_INCH);
        return inches;
    }
    
    // Cook the numbers (if we ever want to)
    private double cook(int orig) {
        return orig;
    }
    
    // Get the distance (in inches) from the left sensor
    public double getLeftDistance() {
        return voltsToInches(sensor_left.getAverageVoltage());
    }
    // Get the distance (in inches) from the right sensor
    public double getRightDistance() {
        return voltsToInches(sensor_right.getAverageVoltage());
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
}