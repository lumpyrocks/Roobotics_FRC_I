/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
/**
 *
 * @author henrypitcairn
 */
public class RooTalon extends Talon {
    private double speed;
    public RooTalon(int channel) {
        super(channel);
    }
    public RooTalon(int slot, int channel) {
        super(slot, channel);
    }
    public double getSpeed() {
        return speed;
    } //
    public void set(double speed) {
        this.speed = speed;
        super.set(speed);
    }
    
}
