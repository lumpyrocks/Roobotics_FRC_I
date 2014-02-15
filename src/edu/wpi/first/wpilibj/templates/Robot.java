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
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
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
    RooKicker kicker;
    RooCosmetics cosmo;
    AnalogChannel ultraSonicLeft;
    AnalogChannel ultraSonicRight;
    
    Encoder encoder;
    DigitalInput dia;
    DigitalInput dib;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystick = new RooJoystick (RobotMap.DRIVE_JOYSTICK_PORT);
        ultraSonicRight = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNE_RIGHT);
        ultraSonicLeft = new AnalogChannel(RobotMap.ULTRASONIC_RANGER_CHANNEL_LEFT);
        rdt = RooDriveTrain.getInstance();
        fl = new RooForkLift(joystick);
        pult = new RooCatapult(joystick);
        kicker = new RooKicker(joystick);
        cosmo = new RooCosmetics ();
        
        dia= new DigitalInput (1);
        dib = new DigitalInput (2);
        encoder = new Encoder (3, 4, true, CounterBase.EncodingType.k4X);
        encoder.start();
    }

    
    public void autonomousInit (){
        cosmo.init();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    public void teleopInit () {
        encoder.start();
        cosmo.init();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Teleop Periodic Functions as "While(Teleop){}", please do not put indefinite loops within it, this is a bad.
        rdt.periodic();
        fl.periodic();
        pult.periodic();
        kicker.periodic();
        
        int thang = encoder.get();
        int otherthang = encoder.getRaw();
        double tooManythangs = encoder.getDistance();
        SmartDashboard.putNumber("DOOD, the encoder.get is totally at like:", thang);
        SmartDashboard.putNumber("DOOD, the encoder.getRaw is totally at like:", otherthang);
        SmartDashboard.putNumber("DOOD, the encoder.getDistance is totally at like:", tooManythangs);
    }
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
