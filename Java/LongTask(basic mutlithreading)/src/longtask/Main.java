package longtask;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Perform a long task
        Runnable longRun = new TaskThread();
        Thread thread = new Thread(longRun);
        thread.start();
        

        // Finish the main thread
        System.out.println("Main thread still running.");
        for (int i = 1; i < 6; i++) {
            System.out.println("Main thread running: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
        System.out.println("Main thread finished.");
    }
}
