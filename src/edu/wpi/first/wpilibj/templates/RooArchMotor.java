/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Dorian
 */
public class RooArchMotor {
    
    Victor archMotor;
    
    private static RooArchMotor arch = null;
    
    public static RooArchMotor getInstance() {
        if (arch==null) {
             arch = new RooArchMotor();
         }
         return arch;
     }
    
    public RooArchMotor() {
        archMotor = new Victor(RobotMap.ARCH_MOTOR_CHANNEL);
}
    
    public void periodic(){
        archMotor.set(RobotMap.ARCH_MOTOR_SPEED);
    }
}
