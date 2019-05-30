package com.exampe.threads;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException, IllegalAccessException{
		
		//pass no threads
		/*MyCustomThreadPool threadpool = new MyCustomThreadPool(4);
		
		for (int i = 0; i < 4; i++) {
			threadpool.submit(new Task());
		}
		threadpool.shutdown();*/
		
		
		Task task = new Task(10);
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
	}
}
