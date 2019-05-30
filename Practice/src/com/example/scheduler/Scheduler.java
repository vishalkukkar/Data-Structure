package com.example.scheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final TreeSet<Machine> machinePool = new TreeSet<>((a, b) -> a.cpu != b.cpu ? a.cpu - b.cpu : (a.ram != b.ram ? a.ram - b.ram : a.core - b.core));
public class Scheduler {

   public Future<T> submit(Task<T> task) {
        Machine required = new Machine(task.cpu, task.ram, 1);
        Machine found = machinePool.ceiling(required);
        if (!found) throw new RuntimeException("All machine busy");
        Future<T> future = found.submit(task);
        machinePool.remove(found);
        machinePool.add(found);    // reorder
   }
}



class Task<T> {   
    public int cpu, ram; // required CPU, RAM for this task
    T execute();    // execute the task and return the computed result of type T
}
