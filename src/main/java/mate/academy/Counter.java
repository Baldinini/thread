package mate.academy;

public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int increment() {
        return count++;
    }
}
