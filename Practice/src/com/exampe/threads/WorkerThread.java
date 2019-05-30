package com.exampe.threads;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread{

	private MyCustomThreadPool myCustomThreadPool;
	private BlockingQueue<Runnable> queue;
	
	public WorkerThread(MyCustomThreadPool myCustomThreadPool, BlockingQueue<Runnable> queue) {
		this.myCustomThreadPool = myCustomThreadPool;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		while(!myCustomThreadPool.isShutDownInitiated.get() || !queue.isEmpty()){
			Runnable r;
			while((r = queue.poll()) != null){
				r.run();
			}
		}
	}

}
