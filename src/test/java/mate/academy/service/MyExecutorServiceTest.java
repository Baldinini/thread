package mate.academy.service;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyExecutorServiceTest {
    private List<Integer> list;
    private ExecutorServiceCalculator executorService;

    @Before
    public void setUp() throws Exception {
        list = ListOfNumbersProducer.getList();
        executorService = new ExecutorServiceCalculator(list);
    }

    @Test
    public void getSum_Ok() {
        Integer expected = ListOfNumbersProducer.getSum();
        Integer actually = executorService.getSum(list);
        assertEquals(expected, actually);
    }
}
