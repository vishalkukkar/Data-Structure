package com.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(4);

		ListNode node = removeDuplicates(head);

		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}

	}

	private static ListNode removeDuplicates(ListNode head) {

		ListNode node = head;
		ListNode previous = new ListNode(0);
		previous.next = head;

		Set<Integer> set = new HashSet<Integer>();

		while (head != null) {

			if (set.contains(head.value)) {
				previous.next = head.next;
			} else {
				set.add(head.value);
				previous = previous.next;
			}

			head = head.next;
		}

		return node;
	}

}
