package org.java.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private final List<Process> processes = new ArrayList<>();

    void addProcess(Process p){
        this.processes.add(p);
    }

    public List<Process> getProcesses() {
        return processes;
    }
}
