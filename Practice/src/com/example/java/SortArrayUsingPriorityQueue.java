package com.example.java;

import java.util.PriorityQueue;

public class SortArrayUsingPriorityQueue {


	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		queue.add(2);
		queue.offer(3);
		
		queue.forEach(System.out::println);

	}

}
