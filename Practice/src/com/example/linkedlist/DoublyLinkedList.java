package com.example.linkedlist;

public class DoublyLinkedList {

	static Node head;

	public static class Node {
		Node prev;
		Node next;
		int val;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6 };
		createDoublyLinkedList(array);
	}

	private static void createDoublyLinkedList(int[] array) {

		Node prev = null;
		Node temp = null;

		for (int i = 0; i < array.length; i++) {
			if (head == null) {
				head = new Node(array[i]);
				prev = head;
				temp = head;
			} else {
				head.next = new Node(array[i]);
				head.prev = prev;

				prev = head;
				head = head.next;
			
			}
		}

		while (temp != null) {

			if (temp.prev != null) {

				System.out.println("prev " + temp.prev.val);
				System.out.println("curr "+temp.val);
				System.out.println();
			}
			temp = temp.next;
		}
	}

	private static void display(Node n1) {

		while (n1 != null) {
			System.out.println(n1.prev.val + " ");
		}

	}

}
