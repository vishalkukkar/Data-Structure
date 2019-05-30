package com.example.scheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Machine {
	   public final AtomicInteger cpu, ram, core;  // available cpu/ram
	   public final int cfgCPU, cfgRAM, cfgCore;// default configured CPU/RAM
	   private final Executor executor = ThreadPool.newWorkStealingPool();

	   public Machine(int cpu, int ram, int core) {
	         this.cpu = new AtomicInteger(this.cfgCPU = cpu);
	         this.ram = new AtomicInteger(this.cfgRAM = ram);
	         this.core = new AtomicInteger(this.cfgCore = core);
	   }

	   public Future<T> submit(final Task<T> task) {
	         if (this.cpu < task.cpu || this.ram < task.ram) {
	             throw new RuntimeException("Not enough resource");
	         }
	         this.cpu.set(this.cpu.get() - task.cpu);
	         this.ram.set(this.ram.get() - task.ram);
	         this.core.decrement();
	         return executor.submit(() -> {
	               T res = task.execute();
	               this.cpu.set(this.cpu.get() + task.cpu);
	               this.ram.set(this.ram.get() + task.ram);
	               this.core.increment();
	               machinePool.remove(this);
	               machinePool.add(this);    // reorder
	               return res;
	         });
	   }
	}