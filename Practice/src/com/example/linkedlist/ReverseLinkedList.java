package com.example.linkedlist;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		//ListNode result = reverseList(head, 0, 3);

		ListNode result  = reverseBetween(head, 2, 4);
		/*while (result != null) {
			System.out.println(result.value);
			result = result.next;
		}*/
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode prev = temp;
		int count = 0;

		ListNode p = head;
		/*while (p != null) {
		
			if (count == m) {
				break;
			}

			prev = p;
			p = p.next;
			count++;
		}
		
	//	System.out.println(prev.value);

		ListNode t = prev;
		while (p != null) {
			count++;
			if (count == n) {
				break;
			}

			prev = p;
			p = p.next;
			

		}*/
		
	//	System.out.println(t.value+" --- "+prev.next.value);

		 ListNode t = reverse(temp.next, head.next.next.next);
		 
		 while(t != null){
			 System.out.println(t.value);
			 t = t.next;
		 }
		p  = prev.next;
		return temp.next;
	}

	public static ListNode reverse(ListNode prev, ListNode next) {

		ListNode last = prev.next;
		ListNode curr = last.next;

		while (curr != next) {
			System.out.println("h");
			last.next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			curr = last.next;
		}

		return last;

	}

	public static ListNode reverseList(ListNode head, int start, int end) {

		if (head == null || head.next == null)
			return head;

		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while (curr != null && start < end) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			start++;
		}
		return prev;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		slow.next = head;

		// Move fast in front so that the gap between slow and fast becomes n
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}

		System.out.println("fast " + fast.value + "  slow " + slow.value);
		// Move fast to the end, maintaining the gap
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println("slow " + slow.value);
		// Skip the desired node
		slow.next = slow.next.next;
		return start.next;
	}

	private static ListNode reverseListRecursive(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode second = head.next;
		head.next = null;

		ListNode rest = reverseListRecursive(second);
		second.next = head;

		return rest;
	}

}
