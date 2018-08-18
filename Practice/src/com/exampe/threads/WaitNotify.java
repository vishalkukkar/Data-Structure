package com.exampe.threads;

public class WaitNotify implements Runnable {

	public Integer count = 0;

	public void run() {
		synchronized (this) {
			while (count <= 5) {
				try {

					Thread.sleep(200);
					System.out.println("waiting for 2000ms for thread " + Thread.currentThread().getName());
					System.out.println("count " + count);
					count++;
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notify();
		}

	}

	public static void main(String[] args) {
		WaitNotify instance = new WaitNotify();
		Thread t1 = new Thread(instance);
		t1.start();

		// Thread t2 = new Thread(instance);
		// t2.start();

		/*
		 * while(instance.count <= 5){ try {
		 * 
		 * System.out.println("waiting 3000ms in main"); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		try {

			synchronized (t1) {

				t1.wait();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("final count " + instance.count);
	}

}
