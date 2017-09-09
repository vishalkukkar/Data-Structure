package com.example.linkedlist;

public class Palindrome {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);

		System.out.println(isPalindrome(head));

	}

	private static Boolean isPalindrome(ListNode head) {

		ListNode t = head;
		ListNode reverseNode = reverseList(head);

		while (t != null) {
			System.out.println(t.val);
			t = t.next;

		}

		while (reverseNode != null && t != null) {
			if (reverseNode.val != t.val) {
				return false;
			} else {
				reverseNode = reverseNode.next;
				t = t.next;
			}
		}
		return true;
	}

	private static ListNode reverseList(ListNode head) {

		if (head == null)
			return null;

		ListNode p1 = head;
		ListNode p2 = p1.next;

		head.next = null;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		return p1;
	}

}
