package org.java.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SJFScheduler implements ISchedulingStrategy{
    @Override
    public Process schedule(Queue queue) {
        List<Process> processes = queue.getProcesses();
        if(processes == null || processes.isEmpty()) return null;
        Process min = Collections.min(queue.getProcesses(), Comparator.comparingInt(Process::getBurstTime));
        processes.remove(min);
        return min;
    }
}
