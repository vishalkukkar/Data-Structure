package com.example.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implement a super queue from set of priority queues
 * 
 * 0 2 1 q1 4 3 5 q2 8 9 7 q3 peek() - should return 0; poll() - should remove 0
 * from q1;
 * 
 * Note : Don't add all queues to single priority queue as items can be infinite
 */

public class SuperPriorityQueue {

	List<PriorityQueue<Integer>> result = null;

	public SuperPriorityQueue(Set<PriorityQueue<Integer>> queues) {
		this.result = new ArrayList<>();

		for (PriorityQueue<Integer> queue : queues) {
			PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
			for (Integer i : queue) {
				temp.add(i);
			}
			result.add(temp);

		}
	}

	/**
	 * Time complexity O(n)(n = total set of priority queues)
	 * 
	 * @return
	 */
	public Integer peek() {

		Integer min = Integer.MAX_VALUE;
		for (PriorityQueue<Integer> p : result) {
			min = Math.min(p.peek(), min);
		}
		return min;
	}

	/**
	 * Time complexity O(n)(n = total set of priority queues)
	 */
	public Integer poll() {

		Integer min = Integer.MAX_VALUE;
		Integer queueIndex = -1;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).peek() < min) {
				queueIndex = i;
				min = result.get(i).peek();
			}
		}

		Integer ele = null;
		if (queueIndex != -1) {

			PriorityQueue<Integer> q = result.get(queueIndex);
			ele = q.poll();
		}
		return ele;
	}

	private void print() {

		for (PriorityQueue<Integer> q : result) {
			System.out.println();
			q.forEach(i -> {
				System.out.print(i + " ");
			});
		}
	}

	public static void main(String[] args) {

		PriorityQueue<Integer> q1 = new PriorityQueue<>();
		q1.add(1);
		q1.add(7);
		q1.add(2);
		PriorityQueue<Integer> q2 = new PriorityQueue<>();
		q2.add(5);
		q2.add(0);
		q2.add(4);
		PriorityQueue<Integer> q3 = new PriorityQueue<>();
		q3.add(6);
		q3.add(8);
		q3.add(10);

		Set<PriorityQueue<Integer>> superQueue = new HashSet<PriorityQueue<Integer>>();
		superQueue.add(q1);
		superQueue.add(q2);
		superQueue.add(q3);

		SuperPriorityQueue s = new SuperPriorityQueue(superQueue);
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.poll());
		s.print();

	}
}
