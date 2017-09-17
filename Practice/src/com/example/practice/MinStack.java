package com.example.practice;

import java.util.Stack;

public class MinStack {

	 public class Node {

			Node next;
			int val;

			Node() {}
			Node(int val) {
				this.val = val;
			}
		}
	 
	Node top;
	Stack<Integer> stack = new Stack<>();

	public void push(int x) {

		if (top == null) {
			stack.push(x);
			top = new Node(x);
		} else {

			if (stack.peek() > x) {
				stack.push(x);
			}
			Node n = new Node(x);
			n.next = top;
			top = n;
		}
	}

	public int getMin() {
		if (stack.isEmpty())
			return 0;

		return stack.peek();
	}

	public void display() {
		while (top != null) {
			System.out.println(top.val);
			top = top.next;
		}
	}

	private void pop() {

		if (top != null && top.val == stack.peek())
			stack.pop();
		top = top.next;

	}

	private int top() {
		if (top != null)
			return top.val;
		return -1;
	}

	public static void main(String[] args) {

		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.top());
		System.out.println(m.getMin());
		m.getMin();

	}

}
