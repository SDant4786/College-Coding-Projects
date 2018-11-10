/* Author: Spencer Dant
Advanced Java programming
11/12/2018
Tortoise and Hare threading
Hare class
*/
package project.pkg18.pkg1.tortoise.and.the.hare.race;

import java.util.Random;

public class Hare implements Runnable{

    private int distance; //hold distance
    private int moveCount;
    
    @Override
    public void run() {
        //hare will randomly start at anytime between 0 and 200
        Random rand = new Random();
        try{
        Thread.sleep(rand.nextInt(11)*100); //random start time
        } catch (InterruptedException ex){}
        distance = 0;
        while (distance<300){
            moveCount = 0;
            
            while (moveCount<100){
            try {
            Thread.sleep(100);
            } catch (InterruptedException ex) {}
            moveCount = moveCount + 10;
            distance = distance +10;
            if (distance >=300){
                break;
            }
            
        }
        System.out.println("Hare: "+ distance);
        
        }
        System.out.println("Hare finished");
    }
    
}
