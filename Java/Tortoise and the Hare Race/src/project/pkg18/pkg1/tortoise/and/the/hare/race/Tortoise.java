/* Author: Spencer Dant
Advanced Java programming
11/12/2018
Tortoise and Hare threading
Tortoise class
*/
package project.pkg18.pkg1.tortoise.and.the.hare.race;

public class Tortoise implements Runnable {
private int time; //Holds the distance 
    @Override
    public void run() {
             while (time < 300) {
        try {
            Thread.sleep(100); //moveement incriments
        } catch (InterruptedException ex) {}
        time= time + 10;
        System.out.println("Tortoise: "+ time);
    }
        System.out.println("Tortoise finished");
    }
    
}
