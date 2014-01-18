/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    RooJoystick joystick;
    RooDriveTrain rdt;
    
    private final int rightDriveTrainPWM = 4;
    private final int leftDriveTrainPWM = 3;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = new RooJoystick (1);
        rdt = new RooDriveTrain(joystick, rightDriveTrainPWM, leftDriveTrainPWM);
        System.out.println("Robot Init did indeed run");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Teleop Periodic Functions as "While(Teleop){}", please do not put indefinite loops within it, this is a bad.
        rdt.periodic();
        System.out.println("" + joystick.rooGetX() + "," + joystick.rooGetY());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
