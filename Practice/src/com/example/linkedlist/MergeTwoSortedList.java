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

	private static ListNode mergeTwoList(ListNode head2, ListNode head) {
		
		return null;
	}

}
