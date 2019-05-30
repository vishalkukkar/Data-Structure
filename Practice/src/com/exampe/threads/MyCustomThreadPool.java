package com.exampe.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyCustomThreadPool {

	
	private int nThreads;
	private List<WorkerThread> workers;
	private BlockingQueue<Runnable> queue;
    AtomicBoolean isShutDownInitiated;
	public MyCustomThreadPool(int nThreads) {
		
		this.nThreads = nThreads;
		workers = new ArrayList<>(nThreads);
		queue = new LinkedBlockingQueue<>();
		isShutDownInitiated = new AtomicBoolean(false);
		
		for (int i = 0; i < nThreads; i++) {
			String threadName = "Thread"+i;
			WorkerThread thread = new WorkerThread(this,queue);
			thread.start();
			workers.add(thread);
		}
	}

	public void submit(Task task) throws InterruptedException, IllegalAccessException {
		
		if(!isShutDownInitiated.get()) 
			queue.put(task);
		else 
			throw new IllegalAccessException();
		
	}

	public void shutdown() {
		isShutDownInitiated = new AtomicBoolean(true);
	}

}
