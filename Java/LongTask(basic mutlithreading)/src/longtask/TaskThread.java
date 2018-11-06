/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtask;

/**
 *
 * @author sdant
 */
public class TaskThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Long task started.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
        System.out.println("Long task finished.");
    }
    
}
