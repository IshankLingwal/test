import java.util.*;

class SharedData {
    private int value;
    private boolean hasValue = false;

    // Producer will call this to put a value
    public synchronized void produce(int val) {
        try {
            while (hasValue) {
                wait(); // Wait until consumer consumes
            }
            value = val;
            System.out.println("Produced: " + value);
            hasValue = true;
            notify(); // Notify the consumer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Consumer will call this to get the value
    public synchronized void consume() {
        try {
            while (!hasValue) {
                wait(); // Wait until producer produces
            }
            System.out.println("Consumed: " + value);
            hasValue = false;
            notify(); // Notify the producer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//We use synchronized to make sure that only one thread can access a piece of code at a time — like putting a lock on a room so only one person can enter at a time.

class Producer extends Thread {
    SharedData data;

    Producer(SharedData data) {
        this.data = data;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.produce(i);
            try {
                Thread.sleep(500); // Optional delay for realism
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    SharedData data;

    Consumer(SharedData data) {
        this.data = data;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            data.consume();
            try {
                Thread.sleep(500); // Optional delay for realism
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);

        producer.start();
        consumer.start();
    }
}
//wait()
// Used to pause a thread until it's allowed to continue.

// When a thread calls wait(), it goes to sleep.

// It releases the lock on the object so that another thread can work.

// notify()
// Used to wake up a thread that is waiting.

// It tells one waiting thread (using wait()) that it can continue now.