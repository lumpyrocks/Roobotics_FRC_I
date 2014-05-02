/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author henrypitcairn
 */
import edu.wpi.first.wpilibj.Victor;
public class RooCatapultMotorPair {
    private Victor catMotor1;
    private Victor catMotor2;
    private boolean inverted;
    private double speed;
    public RooCatapultMotorPair(boolean inverted) {
        catMotor1 = new Victor(RobotMap.LAUNCHER_RIGHT_MOTOR_CHANNEL);
        catMotor2 = new Victor(RobotMap.LAUNCHER_LEFT_MOTOR_CHANNEL);
        this.inverted = inverted;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
        if (inverted) {
            catMotor1.set(-this.speed);
            catMotor2.set(this.speed);
        }
        else {
            catMotor1.set(this.speed);
            catMotor2.set(-this.speed);
        }
    }
    public double getSpeed() {
        return this.speed;
    }
    
}