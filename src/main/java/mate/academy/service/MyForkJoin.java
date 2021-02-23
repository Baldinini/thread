package mate.academy.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100000;
    private List<Integer> list;

    public MyForkJoin(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing(list);
    }

    private Collection<MyForkJoin> createSubtasks() {
        List<MyForkJoin> dividedTasks = new ArrayList<>();
        dividedTasks.add(new MyForkJoin(list.subList(0, list.size() / 2)));
        dividedTasks.add(new MyForkJoin(list.subList(list.size() / 2, list.size())));
        return dividedTasks;
    }

    private Integer processing(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }
}
