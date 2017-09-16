package com.example.queue;

import java.util.Arrays;

public class MyQueue {

	String[] queueArray;
	int front, rear, numberOfItems = 0;
	int sizeOfQueue = 0;

	MyQueue(int size) {
		sizeOfQueue = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");

	}

	public void insert(String input) {

		if (numberOfItems + 1 <= sizeOfQueue) {
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			displayQueue();
		} else {
			System.out.println("MyQueue is already full");
		}

	}

	public void remove() {
		if (numberOfItems > 0) {
			queueArray[front] = "-1";
			front++;
			numberOfItems--;
			displayQueue();
		} else {
			System.out.println("MyQueue is Empty");
		}

	}

	public void displayQueue() {
		for (int i = 0; i < queueArray.length; i++) {

			if (!queueArray[i].equals("-1"))
				System.out.print(queueArray[i] + "    ");
			else {
				System.out.print("      ");
			}

		}
		System.out.println("\n------------------------------------------");
	}

	public void priorityInsert(String input) {
		int j = 0;
		if (numberOfItems == 0)
			insert(input);
		else {

			for (j = numberOfItems - 1; j >= 0 ; j--) {
				if (Integer.parseInt(input) > Integer.parseInt(queueArray[j])) {
					queueArray[j + 1] = queueArray[j];
						
				}else{
					break;
				}
			}

			queueArray[j + 1] = input;
			rear++;
			numberOfItems++; 
			displayQueue();
		}
	}

	public static void main(String[] args) {

		MyQueue queue = new MyQueue(5);
		queue.priorityInsert("10");
		queue.priorityInsert("20");
	//	queue.remove();
		  queue.priorityInsert("15");
		queue.priorityInsert("30");
		//queue.remove();
		queue.priorityInsert("100");
	}

}
