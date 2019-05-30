package com.example.linkedlist;

public class Palindrome {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		/*head.next.next.next.next.next = new ListNode(1);*/

		System.out.println(isPalindrome2(head));

	}
	
	private static Boolean isPalindrome2(ListNode head) {
		
		if(head == null || head.next == null)
			return true;
		
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			
			fast = fast.next.next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
			
			
		}
		
		if(fast.next == null){
			curr = curr.next;
		}
		
		while(prev != null){
			
			System.out.println(prev.value + " "+curr.value);
			if(prev.value != curr.value)
				return false;
			prev = prev.next;
			curr = curr.next;
		}
		
		/*while(prev != null){
			System.out.println("p  " +prev.value);
			prev = prev.next;
		}
		
		while(curr != null){
			System.out.println("c "+curr.value);
			curr = curr.next;
		}*/
		
		return true;
	}

	private static Boolean isPalindrome(ListNode head) {
		
		ListNode clone = getClonedList(head);
		ListNode reverseList = reverseList(head);
		
		while(clone != null){
			if(reverseList.value != clone.value)
				return false;
			reverseList = reverseList.next;
			clone = clone.next;
		}
		return true;
	}

	private static ListNode getClonedList(ListNode head) {
		
		ListNode temp = new ListNode(0);
		ListNode ret = temp;
		ListNode t = head;
		
		while(t != null){
			temp.next = new ListNode(t.value);
			temp = temp.next;
			t = t.next;
		}
		
		return ret.next;
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
