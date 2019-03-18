package com.exampe.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerCosumer {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>();

		Thread t1 = new Thread(new Runnable() {
			int value = 0;

			@Override
			public void run() {
				

				while (true) {
					System.out.println("\n\n");
					try {
						queue.put(value);
						System.out.println("Produced" + value);
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					value++;
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {

						System.out.println("Consumed " + queue.take());
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
