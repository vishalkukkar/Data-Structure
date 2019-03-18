package com.example.linkedlist;

import java.util.Stack;

public class ReorderList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		head.next.next.next.next = new ListNode(5);

		ListNode res = reorderList(head);
		while (res != null) {
			System.out.print(res.value + " --> ");
			res = res.next;
		}
	}

	// temp 1 2 3 4
	// stack 4 3 2 1
	// 1 4 2 3
	public static ListNode reorderList(ListNode head) {

		if (head == null || head.next == null)
			return null;

		ListNode temp = head;

		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.add(head);
			head = head.next;
		}

		int size = stack.size() / 2;
		ListNode result = new ListNode(0);
		ListNode res = result;
		while (size > 0 && temp != null) {

			result.next = new ListNode(temp.value);
			result = result.next;
			result.next = new ListNode(stack.pop().value);
			result = result.next;

			temp = temp.next;
			size--;
		}

		if (stack.size() % 2 != 0)
			result.next = new ListNode(temp.value);
		return res.next;
	}
}
