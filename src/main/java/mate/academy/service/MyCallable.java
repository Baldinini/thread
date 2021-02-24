package mate.academy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {
    public static final int THREADS = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private List<Integer> values;

    public MyCallable(List<Integer> values) {
        this.values = values;
    }

    public static Integer getSum(List<Integer> list) {
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            List<Integer> newList = list
                    .subList(i * list.size() / THREADS, list.size() / THREADS * (i + 1));
            callables.add(new MyCallable(newList));
        }
        int sum = 0;
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Doesn't work correctly", e);
        } finally {
            executorService.shutdown();
        }
    }

    @Override
    public Integer call() throws Exception {
        return values.stream().reduce(0, Integer::sum);
    }
}
