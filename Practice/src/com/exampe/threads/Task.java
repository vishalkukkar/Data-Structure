package com.exampe.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{

	
	AtomicInteger x = new AtomicInteger(0);
	AtomicInteger y = new AtomicInteger(1);
	AtomicInteger z = new AtomicInteger(0);
	
	private int n;
	public Task(int n){
		this.n = n;
	}
	
	@Override
	public void run() {
		
			
			while(n != 0) {
				
				z = new AtomicInteger(x.intValue() + y.intValue());
				System.out.println(z);
				x = y;
				y = z;
				n--;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
	}

}
