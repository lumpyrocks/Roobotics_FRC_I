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
    
    private static RooAutoRanger rar;
    public static RooAutoRanger getInstance() {
        if (rar==null) {
            rar = new RooAutoRanger();
        }
        return rar;
    }
    
    private final double ERROR_MARGIN = 10.0;
    private RooAutoRangerSensorPair sensors;
    private RooJoystick joystick;
    private RooDriveTrain driveTrain;
    
    public RooAutoRanger() {
        this.driveTrain = RooDriveTrain.getInstance();
        this.joystick = RooJoystick.getInstance();
        sensors = RooAutoRangerSensorPair.getInstance();
    }
    public void periodic() {
       // double diff = sensors.getDifference();
        
        SmartDashboard.putNumber("Ranger: ", sensors.getDistance());
        SmartDashboard.putNumber("Ranger in Inches: ", sensors.voltsToInches(sensors.getDistance()) );
        //SmartDashboard.putNumber("Left Ranger: ", sensors.getLeftDistance());
        /*SmartDashboard.putNumber(RobotMap.SMARTDASHBOARD_SKEW_OUTPUT, diff);
        /if (joystick.getRawButton(RobotMap.USE_AUTORANGER_TO_CORRECT)){
            if (Math.abs(diff)>=ERROR_MARGIN) {
                if (sensors.getLeftDistance()>sensors.getRightDistance()) {
                    driveTrain.setRight(1 - (sensors.getRightDistance()/sensors.getLeftDistance()));
                }
                else if (sensors.getLeftDistance()<sensors.getRightDistance()) {
                 driveTrain.setLeft(1 - (sensors.getLeftDistance()/sensors.getRightDistance()));
                }
            }
        } */
    }
}
