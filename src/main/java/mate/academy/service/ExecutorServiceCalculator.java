package mate.academy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCalculator {
    public static final int THREADS = 10;
    private final List<Integer> list;

    public ExecutorServiceCalculator(List<Integer> list) {
        this.list = list;
    }

    public Integer getSum(List<Integer> list) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            List<Integer> newList = list
                    .subList(i * list.size() / THREADS, list.size() / THREADS * (i + 1));
            callables.add(new SumCalculatorCallable(newList));
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
}
