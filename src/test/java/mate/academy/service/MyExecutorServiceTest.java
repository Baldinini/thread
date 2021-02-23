package mate.academy.service;

import java.util.List;
import java.util.concurrent.Callable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyExecutorServiceTest {
    private List<Integer> list = Util.getList();
    private Callable<Integer> callable;

    @Test
    public void getSum_Ok() {
        Integer expected = list.stream().reduce(0, Integer::sum);
        Integer actually = MyCallable.getSum(list);
        assertEquals(expected, actually);
    }
}
