package com.example.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
//		ListNode result = reverseList(head);
//		
//		while(result != null){
//			System.out.println(result.val);
//			result = result.next;
//		}
		
		System.out.println("\n\n");
		ListNode result1 = reverseListRecursive(head);
		while(result1 != null){
			System.out.println(result1.val);
			result1 = result1.next;
		}
		
	}
	
	private static ListNode reverseListRecursive(ListNode head) {

		if(head == null || head.next == null) return head;
		
		ListNode second = head.next;
		head.next = null;
		
		ListNode rest = reverseListRecursive(second);
		second.next = head;
		
		return rest;
	}

	public static ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
