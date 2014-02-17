/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Dorian
 */
public class RooScoreAGoal {
    
    private static RooScoreAGoal rsg;
    public static RooScoreAGoal getInstance (){
        if (rsg == null){
            rsg = new RooScoreAGoal ();
        }
        return rsg;
    }
    
    private RooKicker kicker;
    private RooForkLift fl;
    private RooCatapult pult;
    private RooDriveTrain rdt;
    
    private RooScoreAGoal (){
        kicker = RooKicker.getInstance();
        fl = RooForkLift.getInstance();
        pult = RooCatapult.getInstance();
        rdt = RooDriveTrain.getInstance();
    }
}
