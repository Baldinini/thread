package mate.academy;

import org.apache.log4j.Logger;

public class ThreadByThread extends Thread {
    private static final Logger logger = Logger.getLogger(ThreadByThread.class);
    private Counter counter;

    public ThreadByThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("My thread which extends Thread is running...");
        while (counter.getCount() != 100) {
            int number = counter.increment();
            logger.info("Thread: " + number);
        }
    }
}
