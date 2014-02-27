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
public class RooTimer implements Runnable{
    private int miliSecondsPast;
    private boolean isFinished;
    private final int timerThreshold = 500;
    private Thread t;
    
    public RooTimer() {
        t = new Thread(this);
    }
    
    
    public void increaseSeconds() {
        while (miliSecondsPast<timerThreshold) {
            try {
                Thread.sleep(1);
                miliSecondsPast++;
            } catch (java.lang.InterruptedException e) {}
        }
    }
    public int getSeconds() {
        return miliSecondsPast;
    }
    public boolean isFinished() {
        return isFinished;
    }
    
    public void run() {
        this.isFinished = false;
        increaseSeconds();
        this.isFinished = true;
    }
}
