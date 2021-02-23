package mate.academy.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static List<Integer> getList() {
        return IntStream.range(0, 1000000)
                .boxed()
                .collect(Collectors.toList());
    }
}
