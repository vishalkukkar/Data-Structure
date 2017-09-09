package com.example.stack;

import java.util.Stack;

public class MinStack {

	Node top;
	Stack<Integer> minStack = new Stack<Integer>();

	protected void push(int data) {

		if (top == null) {
			top = new Node(data);
			minStack.push(data);
		} else {
			Node node = new Node(data);
			node.next = top;
			top = node;

			if (data < minStack.peek()) {
				minStack.push(data);
			}
		}
	}

	protected void display() {

		while (top != null) {
			System.out.println(top.data);
			top = top.next;
		}
	}

	protected Node pop() {

		if (top == null)
			return null;
		else {
			if (top.data == minStack.peek()) {
				minStack.pop();
			}
			Node t = top;
			top = top.next;
			return t;
		}
	}
	
	protected Node peek() {
		return top;
	}

	private int min() {

		return minStack.peek();

	}
	
	protected boolean empty() {
		if(top == null)
			return true;
		return false;
	}

	public static void main(String[] args) {

		MinStack stack = new MinStack();
		stack.push(100);
		stack.push(33);
		stack.push(99);
		stack.push(2);
		stack.pop();
		
		System.out.println(stack.min());
	}



}
