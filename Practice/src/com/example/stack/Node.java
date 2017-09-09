package com.example.stack;

public class Node<T> {

	T data;
	Node next;

	Node(T x) {
		this.data = x;
		next = null;
	}

}
