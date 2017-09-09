package com.example.stack;

import java.util.Stack;

public class QueueViaStacks {

	Stack<Node> stack1 = new Stack<Node>();
	Stack<Node> temp = new Stack<Node>();

	public void enqueue(Node n) {
		if (stack1.isEmpty()) {
			stack1.push(n);
		} else {

			while (!stack1.isEmpty())
				temp.push(stack1.pop());

			stack1.push(n);

			while (!temp.isEmpty())
				stack1.push(temp.pop());
		}
	}

	public void dequeue() {
		stack1.pop();
	}

	public void display() {

		while (!stack1.isEmpty())
			System.out.print(" " + stack1.pop().data);

	}

	public static void main(String[] args) {

		QueueViaStacks q = new QueueViaStacks();
		q.enqueue(new Node(1));
		q.enqueue(new Node(2));
		q.enqueue(new Node(3));
		q.enqueue(new Node(4));
		
		q.dequeue();

		q.display();

	}

}
