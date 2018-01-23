package com.example.java;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Person> queue = new PriorityQueue<Person>();
		queue.add(new Person(2, "name", "surname", "email"));
		queue.add(new Person(3, "name", "surname", "email"));
		queue.add(new Person(1, "name", "surname", "email"));

		while (!queue.isEmpty()) {
			Person p = queue.remove();
			System.out.println(p.toString());
		}
	}

}
