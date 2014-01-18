package edu.wpi.first.wpilibj.templates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.AnalogChannel;
/**
 *
 * @author Dorian
 */
public class RooUltraSonicRangeFinder extends AnalogChannel {
    private int bitsToAverage = 1;

    public RooUltraSonicRangeFinder (int channel){
        super (channel);
        super.setAverageBits(channel);
    }
    
    /**
     * 
     * @param change -- the number added to amount of bits sampled and averaged per return.
     */
    public void changeAverageBits(int change){
        super.setAverageBits (super.getAverageBits()+ change);
        System.out.println("New Average Bits =" + super.getAverageBits());
    }
    
    public double getRaw(){
        return super.getAverageVoltage();
    }
}
