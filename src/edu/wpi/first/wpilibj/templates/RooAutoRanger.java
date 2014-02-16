/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author henrypitcairn
 */
public class RooAutoRanger {
    private final double ERROR_MARGIN = 10.0;
    private RooAutoRangerSensorPair sensors;
    private RooJoystick joystick;
    private RooDriveTrain driveTrain;
    
    public RooAutoRanger(RooJoystick joystick, RooDriveTrain driveTrain) {
        this.driveTrain = driveTrain;
        this.joystick = joystick;
        sensors = new RooAutoRangerSensorPair();
    }
    public void adjustPosition() {
        double diff = sensors.getDifference();
        
        SmartDashboard.putNumber("Right Ranger: ", sensors.getRightDistance());
        SmartDashboard.putNumber("Left Ranger: ", sensors.getLeftDistance());
        SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_SKEW_OUTPUT, diff);
        
        if (Math.abs(diff)>=ERROR_MARGIN && joystick.getRawButton(RobotMap.USE_AUTORANGER_TO_CORRECT)) {
            if (sensors.getLeftDistance()>sensors.getRightDistance()) {
                driveTrain.setRight(1 - (sensors.getRightDistance()/sensors.getLeftDistance()));
            }
            else if (sensors.getLeftDistance()<sensors.getRightDistance()) {
                driveTrain.setLeft(1 - (sensors.getLeftDistance()/sensors.getRightDistance()));
            }
//            diff = sensors.getAverageDifference();
        }
    }
}
