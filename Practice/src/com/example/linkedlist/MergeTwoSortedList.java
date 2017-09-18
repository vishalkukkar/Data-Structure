package com.example.linkedlist;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(5);
		head.next = new ListNode(10);
		head.next.next = new ListNode(15);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(23);

		ListNode res = mergeTwoList(head2, head);
		System.out.println("Result");
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {

		if(l1 == null && l2 == null)
			return null;
		ListNode res = new ListNode(0);
		ListNode temp = res;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			temp = temp.next;
		}

		while (l1 != null) {
			temp.next = new ListNode(l1.val);
			temp = temp.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			temp.next = new ListNode(l2.val);
			temp = temp.next;
			l2 = l2.next;
		}

		return res.next;
	}
}
