package com.example.linkedlist;

public class DeleteMiddleNode {

	public static void main(String[] args) {

		ListNode head = new ListNode(7);
		head.next = new ListNode(1);
		head.next.next = new ListNode(6);

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(2);

		ListNode node = addeelments(head, head2);

		System.out.println(node);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode addeelments(ListNode head, ListNode head2) {

		int carry = 0;
		ListNode addition = null;
		int count = 0;
		while (head != null) {

			count = head.val + head2.val;
			System.out.println(count);
			addition = new ListNode(count % 10 + carry);
			carry = count / 10;
			
			System.out.println(" additon " + addition.val+ "   carry "+carry);
			addition = addition.next;
			head = head.next;
			head2 = head2.next;
		}

		return addition;
	}

}
