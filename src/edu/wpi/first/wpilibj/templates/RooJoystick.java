/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
/**
 *
 * @author Dorian
 */
public class RooJoystick extends Joystick {
    private final double deadzone =.05 ;   
    public RooJoystick (int channel){
        super (channel);
        
    }
    
    /**
     *Returns the square (nonpositive) of getX unless x is miniscule deadzone  
     * @return
     */
    public double rooGetX(){
        double x = super.getX();
        if (Math.abs(x) < deadzone){
            x=0;
        }
        else{
            x =x*x*x;
        }
        return x;
    }
    /**
     *Returns the square (nonpositive) of getX unless x is miniscule deadzone  
     * @return
     */
    public double rooGetY(){
        double y = super.getY();
        if (Math.abs(y) < deadzone){
            y=0;
        }
        else{
            y =y*Math.abs(y);
        }
        return y;
    }
}
