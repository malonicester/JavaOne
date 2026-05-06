package org.java.scheduler;

import java.util.ArrayList;
import java.util.List;

// Multilevel Queue Scheduler
public class MultilevelQueueScheduler {
    private final List<Queue> queues = new ArrayList<>();
    private final List<ISchedulingStrategy> strategies = new ArrayList<>();

    public void addQueue(Queue queue,ISchedulingStrategy strategy){
        queues.add(queue);
        strategies.add(strategy);
    }
}
