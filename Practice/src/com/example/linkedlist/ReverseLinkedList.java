package com.example.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		ListNode result = reverseList(head);
		
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode reverseList(ListNode head) {
	    if(head==null||head.next==null)
	        return head;
	 
	    ListNode prev = null;
	    ListNode curr = head;
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
