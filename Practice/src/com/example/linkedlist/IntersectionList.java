package com.example.linkedlist;

public class IntersectionList {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode head2 = new ListNode(9);
		head2.next = new ListNode(8);
		head2.next.next = new ListNode(7);
		head2.next.next.next = head.next.next.next;


		head = isIntersection(head, head2);
		System.out.println(head.val);
		
	}

	private static ListNode isIntersection(ListNode headA, ListNode headB) {

		ListNode temp1 = headA;
		ListNode temp2 = headB;

		int len1 = getLength(headA);
		int len2 = getLength(headB);

		if (len1 > len2) {

			while (len1 != len2) {
				temp1 = temp1.next;
				len1--;
			}
		} else if (len2 > len1) {
			while (len2 != len1) {
				temp1 = temp1.next;
				len2--;
			}
		}
		
		
		if (temp1 == null && temp2 == null)
			return null;

		while (temp1 != null && temp2 != null) {
			if (temp1.val == temp2.val)
				return temp1;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return null;

	}

	private static int getLength(ListNode headA) {
		int len = 0;

		while (headA != null) {
			len++;
			headA = headA.next;
		}
		return len;
	}

}
