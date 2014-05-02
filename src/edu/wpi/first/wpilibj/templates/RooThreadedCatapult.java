package edu.wpi.first.wpilibj.templates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henrypitcairn
 */

public class RooThreadedCatapult implements Runnable {

    private final Thread t;
    public RooThreadedCatapult() {
        t = new Thread(this);
    }
    public void launch() { t.start(); }
    public void run() {
        RooCatapult rc = RooCatapult.getInstance();
        rc.launch(true);
    }
    
}
