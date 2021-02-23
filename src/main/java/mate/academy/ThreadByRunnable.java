package mate.academy;

import org.apache.log4j.Logger;

public class ThreadByRunnable implements Runnable {
    private static final Logger logger = Logger.getLogger(ThreadByRunnable.class);
    private Counter counter;

    public ThreadByRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("My thread which implements Runnable is running...");
        while (counter.getCount() != 100) {
            logger.info("Runnable: " + counter.increment());
        }
    }
}
