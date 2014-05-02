/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Dorian
 */
public class RooAdjust {
    
    RooGyro gyro;
    RooDriveTrain rdt;
    RooJoystick joystick;
    private double skew;
    private double motorSkew;
    
    private static RooAdjust adj = null;
    
    public static RooAdjust getInstance() {
        if (adj==null) {
             adj = new RooAdjust();
         }
         return adj;
     }
    
    private RooAdjust (){
        gyro = RooGyro.getInstance();
        rdt = RooDriveTrain.getInstance();
        joystick = RooJoystick.getInstance();
    }
    
    public void adjust (){
        if (joystick.getRawButton(RobotMap.USE_AUTORANGER_TO_CORRECT)){
            skew = gyro.getSimplestAngle();
            if (Math.abs(skew)<=3){
                motorSkew = skew/180;
                rdt.setLeft(motorSkew);
                rdt.setRight(-motorSkew);
            }
            System.out.println(skew);
        }
    }
}
