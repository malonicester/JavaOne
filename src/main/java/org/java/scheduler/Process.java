package org.java.scheduler;

public class Process {
    private int pid;
    private int priority;
    private int burstTime;

    public Process(int pid, int priority, int burstTime) {
        this.pid = pid;
        this.priority = priority;
        this.burstTime = burstTime;
    }

    public int getPid() {
        return pid;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurstTime() {
        return burstTime;
    }
}
