package com.example.linkedlist;

public class CRUD {
	static ListNode head = null;

	public static void main(String[] args) {

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		// System.out.println(isLoop(head));
		// ListNode n = deleteNode(4, head);

		// ListNode node = new ListNode(10);
		// addNode(node, 3);

		// System.out.println(isLoop(head));

		ListNode t = reverseLinkedList();
		System.out.println("result");

		while (t != null) {
			System.out.println(t.val);
			t = t.next;
		}

		/*
		 * while (head != null) { System.out.println(head.val); head =
		 * head.next; }
		 */
	}

	private static ListNode reverseLinkedList() {

		if (head == null)
			return head;

		if (head.next == null)
			return head;

		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev; 
			prev = curr;
			curr = next;
		}

		return prev;

	}
	
	private static ListNode addNode(ListNode node, int i) {

		if (head == null)
			return null;

		// ListNode prev = head;
		ListNode curr = head;

		int count = 1;
		while (curr != null) {

			if (count == i) {

				node.next = curr.next.next;
				curr.next = node;
			} else {
				// prev = prev.next;
				curr = curr.next;
			}

			count++;

		}

		return head;

	}

	static ListNode deleteNode(int val, ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.val == val)
			return head = head.next;

		ListNode prev = head;
		ListNode curr = head.next;

		while (prev != null && curr != null) {
			System.out.println(curr.val);
			if (curr.val == val) {
				prev.next = curr.next;
				return head;
			} else {
				prev = prev.next;
				curr = curr.next;
			}
		}
		return head;

	}

	private static Boolean isLoop(ListNode head) {

		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head.next.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			} else {
				slow = slow.next;
				fast = fast.next;
			}
		}

		return false;

	}

}
