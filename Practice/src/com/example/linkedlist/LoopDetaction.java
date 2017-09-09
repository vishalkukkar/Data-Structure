package com.example.linkedlist;

public class LoopDetaction {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(5);

		System.out.println(isLoop(head));

	}

	private static Boolean isLoop(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (slow != null &&fast.next != null && fast.next.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
			
		}
		return false;
	}

}
