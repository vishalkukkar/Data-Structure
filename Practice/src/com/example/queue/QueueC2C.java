package com.example.queue;

public class QueueC2C {

	private static class Node {
		private Node head;
		private Node tail;
		private Node next;
		private int data;

		private Node(int data) {
			this.data = data;
		}

		public boolean isEmpty() {
			return head == null;
		}

		public void add(int data) {
			Node node = new Node(data);
			if (tail != null) {
				tail.next = node;
			}
			tail = node;
			if (head == null)
				head = node;
		}

		public Node remove(Node head) {
			if (head != null)
				head = head.next;
			if (head == null)
				tail = null;
			return head;

		}

		public void display(Node head) {
			while (head != null) {
				System.out.print("    " + head.data);
				head = head.next;
			}
		}

	}

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.display(node);
		Node newHead = node.remove(node);
		System.out.println("");
		node.display(newHead);
		node.next.next.next = new Node(4);
		System.out.println();
		node.display(newHead);

	}

}
