/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Gyro;
/**
 *
 * @author Dorian
 */

public class RooGyro {
    private Gyro gyro;
    
    private static RooGyro rooGyro;
    public static RooGyro getInstance (){
        if (rooGyro == null){
            rooGyro = new RooGyro ();
        }
        return rooGyro;
    }
    
    private RooGyro (){
        gyro = new Gyro (RobotMap.GYRO_CHANNEL);
    }
    
    public double getAngle (){
        return gyro.getAngle();
    }
}
