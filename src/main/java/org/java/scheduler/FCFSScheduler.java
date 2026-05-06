package org.java.scheduler;

// First Come First Serve Scheduler
public class FCFSScheduler implements ISchedulingStrategy{
    @Override
    public Process schedule(Queue queue) {
        return queue.getProcesses().isEmpty() ? null : queue.getProcesses().removeFirst();
    }
}
