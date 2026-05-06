package org.java.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorityScheduler implements ISchedulingStrategy {
    @Override
    public Process schedule(Queue queue) {
        List<Process> processes = queue.getProcesses();
        if (processes.isEmpty()) return null;
        Process highestPriority = Collections.min(processes, Comparator.comparingInt(Process::getPriority));
        processes.remove(highestPriority);
        return highestPriority;
    }
}
