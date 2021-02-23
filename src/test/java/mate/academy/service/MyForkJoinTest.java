package mate.academy.service;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyForkJoinTest {
    private final List<Integer> list = Util.getList();
    private final MyForkJoin forkJoin = new MyForkJoin(list);

    @Test
    public void getSum_Ok() {
        Integer expected = list.stream().reduce(0, Integer::sum);
        Integer actually = forkJoin.compute();
        assertEquals(expected, actually);
    }
}
