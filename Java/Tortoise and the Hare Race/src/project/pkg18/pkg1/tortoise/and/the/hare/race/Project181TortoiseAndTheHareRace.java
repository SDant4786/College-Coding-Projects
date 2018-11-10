/* Author: Spencer Dant
Advanced Java programming
11/12/2018
Tortoise and Hare threading
*/


package project.pkg18.pkg1.tortoise.and.the.hare.race;

public class Project181TortoiseAndTheHareRace {

    public static void main(String[] args) {
        
        //create threads
        Runnable hare = new Hare();
        Runnable tortoise = new Tortoise();
        Thread hareThread = new Thread(hare);
        Thread tortoiseThread = new Thread(tortoise);
        
        //run threads
        hareThread.start();
        tortoiseThread.start();
    }
    
}
