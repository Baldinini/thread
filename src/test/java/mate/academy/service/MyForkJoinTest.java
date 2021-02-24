package mate.academy.service;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyForkJoinTest {
    private List<Integer> list;
    private MyForkJoin forkJoin;

    @Before
    public void setUp() throws Exception {
        list = ListOfNumbersProducer.getList();
        forkJoin = new MyForkJoin(list);
    }

    @Test
    public void getSum_Ok() {
        Integer expected = ListOfNumbersProducer.getSum();
        Integer actually = forkJoin.compute();
        assertEquals(expected, actually);
    }
}
