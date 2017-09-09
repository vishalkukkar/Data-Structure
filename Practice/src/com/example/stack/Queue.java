package com.example.stack;

public class Queue {

	Node head;
	Node tail;

	public void enqueue(Node n) {
		if (head == null ) {
			head = n;
			tail =head;
		} else {
			tail.next  = n ;
			tail = n;

		}
	}

	public void dequeue() {
		System.out.println(this.head);
		if (head != null) {
			head = head.next;
		}
		
	}

	public void display() {

		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
		
	}

	public static void main(String[] args) {

		Queue q = new Queue();
		q.enqueue(new Node(1));
		q.enqueue(new Node(2));
		q.enqueue(new Node(3));
		q.enqueue(new Node(4));
		q.enqueue(new Node(5));
		q.dequeue();
		q.dequeue();
		q.display();
		
		
	}

}
