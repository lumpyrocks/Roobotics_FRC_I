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
import java.util.Random;
public class RooWreakHavoc implements Runnable, RooCommonSense {
    
    private static RooWreakHavoc rwh = null;
    public static RooWreakHavoc getInstance() {
        if (rwh == null) {
            rwh = new RooWreakHavoc();
        }
        return rwh;
    }
    private RooCatapult rc;
    private RooDriveTrain rdt;
    private RooCatapult rcat;
    private RooForkLift rf;
    private Random rn;
    private boolean run;
    private Thread t = null;
    
    public RooWreakHavoc() {
        this.rn = new Random();
        this.run = false;
        this.rcat = RooCatapult.getInstance();
        this.rf = RooForkLift.getInstance();
        this.rdt = RooDriveTrain.getInstance();
        this.rc = RooCatapult.getInstance();
        this.t = new Thread(t);
    }
    
    public void autonInit (){
        t.start();
    }
    
    public int randInt() {
        int retInt = rn.nextInt();
        return 0;
    }
    // Public functions
    public void killEveryone() {
    
    }
    public void randomForkLift() {
        for (int i=0; i<10; i++) {
            try {
                rf.setSpeed(1.0);
                Thread.sleep(1000);
                rf.setSpeed(-1.0);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        rf.setSpeed(0.0);
    }
    public void spinInCircles() {
        rdt.setLeft(-1.0);
        rdt.setRight(1.0);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        rdt.setBoth(0.0);
    }
    public void fullSteamAhead() {
        rdt.setBoth(1.0);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        rdt.setBoth(0.0);
    }
    
    public void randomforward(int maxSteps){
           for(int i =0; i<maxSteps; i++){
               rdt.setBoth(1.0);
               try{
                   Thread.sleep(rn.nextInt());
               }
               catch(java.lang.InterruptedException e){
               }
               rdt.setBoth(0);
               try{
                   Thread.sleep(rn.nextInt());
               }
               catch(java.lang.InterruptedException e){
               }
           }
        }
    public void invertControls() {
        
    }
    public void lockOnFullPower() {
        
    }
    public void startWreakingHavoc() {
        this.run = true;
        while (run) {
            randomForkLift();
            spinInCircles();
            fullSteamAhead();
        }
    }
    public void stopWreakingHavoc() {
        this.run = false;
    }
    public boolean isCurrentlyWreakingHavoc() {
        return this.run;
    }

    public void run() {
//        this.run = true;
        startWreakingHavoc();
    }

    public void smackChip(double speed) {
        rc.launch(false);
        randomForkLift();
    }
}
