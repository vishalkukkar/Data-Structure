package com.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllDuplicates {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(5);

		ListNode node = deleteDuplicates(head);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode curr = temp;

		while (curr.next != null && curr.next.next != null) {

			if (curr.next.val == curr.next.next.val) {
				int dup = curr.next.val;
				while (curr.next != null && curr.next.val == dup) {
					curr.next = curr.next.next;
				}
			} else {
				curr = curr.next;
			}
		}

		return temp.next;

	}

}
