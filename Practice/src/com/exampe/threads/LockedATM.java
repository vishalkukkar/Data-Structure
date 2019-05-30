package com.exampe.threads;

import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {

	Lock lock;
	Integer bal;

	public LockedATM(int bal) {

		this.bal = bal;
		lock = new ReentrantLock();
	}

	private void deposite(int amt) {
		lock.lock();
		//process
		lock.unlock();
	}

	private void withdrawMoney(int amt) {

	}

	public static void main(String[] args) {
		LockedATM l = new LockedATM(1000);
		l.withdrawMoney(100);
		l.deposite(100);
		
		StringTokenizer token = new StringTokenizer("", " " );
		token.hasMoreTokens();
		

}
