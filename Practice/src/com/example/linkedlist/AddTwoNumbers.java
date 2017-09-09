package com.example.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode head = new ListNode(5);
	

		ListNode head2 = new ListNode(5);


		ListNode res = addTwoNumbers(head, head2);
		System.out.println("Result");
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int len1 = getLength(l1);
		int len2 = getLength(l2);

		if (len1 > len2) {
			int diff = len1 - len2;
			while (diff != 0) {
				l1 = l1.next;
				diff--;
			}
		} else if (len2 > len1) {
			int diff = len2 - len1;
			while (diff != 0) {
				l2 = l2.next;
				diff--;
			}
		}

		ListNode t = null;
		ListNode prev = null;
		ListNode add = null;

		int carry = 0;
		while (l1 != null) {
			int addition = l1.val + l2.val + carry;
			if (addition > 9) {
				if (addition % 10 > 0) {
					carry = addition % 10;
					addition = addition / 10;
				} else if (addition % 10 == 0) {
					carry  = addition / 10;
					addition = 0;
				} else {

					addition = addition / 10;
				}
			}

			System.out.println(addition);

			l1 = l1.next;
			l2 = l2.next;
			add = new ListNode(addition);

			if (t == null) {
				t = add;
			} else {
				prev.next = add;
			}

			prev = add;
			add = add.next;

		}

		System.out.println("c "+carry);
		if (carry > 0 ){
			add = new ListNode(carry);
		}

		return t;

	}

	private static int getLength(ListNode head) {
		ListNode temp = head;

		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

}
