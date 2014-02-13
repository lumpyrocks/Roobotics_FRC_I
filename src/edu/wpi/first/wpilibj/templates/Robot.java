/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogChannel;
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
    RooForkLift fl;
    RooCatapult pult;
    Encoder encoder;
    AnalogChannel ultraSonicLeft;
    AnalogChannel ultraSonicRight;
    
    //These should be put into RobotMap
    private final int rightDriveTrainPWM = 4;
    private final int leftDriveTrainPWM = 3;
    private final int leftPultPWM = 6;
    private final int rightPultPWM = 5;
    private final int kickerPWM = 7;
    private final int forkliftPWM = 8;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = new RooJoystick (RobotMap.DRIVE_JOYSTICK_PORT);
        ultraSonicRight = new AnalogChannel(1);
        ultraSonicLeft = new AnalogChannel(2);
        rdt = new RooDriveTrain(joystick, ultraSonicRight, ultraSonicLeft);
        fl = new RooForkLift(joystick);
        pult = new RooCatapult(joystick);
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
        fl.periodic();
        pult.periodic();
        //encoder.s
        //SmartDashboard.putNumber("DOOD, the encoder.get is totally at like:", encoder.get());
        //SmartDashboard.putNumber("DOOD, the encoder.getRaw is totally at like:", encoder.getRaw());
        //SmartDashboard.putNumber("DOOD, the encoder.getDistance is totally at like:", encoder.getDistance());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
