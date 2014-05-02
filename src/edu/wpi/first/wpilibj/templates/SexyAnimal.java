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
public class SexyAnimal implements Runnable {
    private Thread t;
    public SexyAnimal() {
        t = new Thread(this);
        t.start();
    }
    public void run() {
        while(true) {
            System.out.println("SEXY ANIMALS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            try {
                Thread.sleep(50000);
            }
            catch (java.lang.InterruptedException e) {}
        } 
    }
}
