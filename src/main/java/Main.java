import mate.academy.Counter;
import mate.academy.ThreadByRunnable;
import mate.academy.ThreadByThread;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(0);

        ThreadByThread myThread = new ThreadByThread(counter);
        myThread.start();

        ThreadByRunnable threadByRunnable = new ThreadByRunnable(counter);
        new Thread(threadByRunnable).start();
    }
}
