import java.util.*;

class CSthread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) { // run 5 times for demonstration
            System.out.println("CSthread - execution count: " + i);
            try {
                Thread.sleep(500); // pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("CSthread interrupted");
            }
        }
    }
}

class ITthread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) { // run 5 times for demonstration
            System.out.println("ITthread - execution count: " + i);
            try {
                Thread.sleep(500); // pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("ITthread interrupted");
            }
        }
    }
}

public class Multithreads {
    public static void main(String[] args) {
        CSthread cs = new CSthread();
        ITthread it = new ITthread();
        
        cs.start(); // Start CSthread
        it.start(); // Start ITthread
    }
}
