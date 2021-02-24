package mate.academy.service;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCalculatorCallable implements Callable<Integer> {
    private final List<Integer> values;

    public SumCalculatorCallable(List<Integer> values) {
        this.values = values;
    }

    @Override
    public Integer call() throws Exception {
        return values.stream().reduce(0, Integer::sum);
    }
}
