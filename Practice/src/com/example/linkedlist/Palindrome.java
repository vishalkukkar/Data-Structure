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
		ListNode reverseList = reverseList(head);
		
		while(reverseList != null){
			if(reverseList.value != t.value)
				return false;
			reverseList = reverseList.next;
			t = t.next;
		}
		return true;
	}

	private static ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		return prev;
	}

}
