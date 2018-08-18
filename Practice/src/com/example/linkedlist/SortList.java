package com.example.linkedlist;

/**
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4
 * 
 * Example 2:
 * 
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * 
 */
public class SortList {

	public static void main(String[] args) {

		
	}

	public ListNode sortList2(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;
		ListNode l1 = sortList2(head);
		ListNode l2 = sortList2(slow);

		return merge2(l1, l2);
	}
	
	private ListNode merge2(ListNode l1, ListNode l2) {

		ListNode temp = new ListNode(-1);
		ListNode t = temp;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				temp.next = new ListNode(l1.val);
				temp = temp.next;
				l1 = l1.next;
			} else {
				temp.next = new ListNode(l2.val);
				temp = temp.next;
				l2 = l2.next;
			}
		}

		if (l1 != null)
			temp.next = new ListNode(l1.val);

		if (l2 != null)
			temp.next = new ListNode(l2.val);

		return t.next;
	}
	
	
	ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return merge(l1, l2);
	}

	ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return l.next;
	}
}
