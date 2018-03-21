package com.example.linkedlist;

import java.io.Serializable;
import java.util.Stack;

public class AddTwoNumbers implements Serializable {

	public static void main(String[] args) {

		/*ListNode head = new ListNode(7);

		ListNode head2 = new ListNode(8);
		
		ListNode res = addTwoNumbers(head2, head);
		System.out.println("Result");
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}*/
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(22);
		s.push(2);
		s.push(3);
		
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);
		int sum = 0;
		int carry = 0;
		ListNode temp = result;
		while (l1 != null && l2 != null) {

			sum = l1.val + l2.val + carry;

			temp.next = new ListNode(sum % 10);
			carry = sum / 10;
			temp = temp.next;

			System.out.println(sum);

			l1 = l1.next;
			l2 = l2.next;

		}

		while(l1 != null){
			int val = l1.val + carry;
			temp.next = new ListNode(val % 10);
			carry = val / 10;
			System.out.println(sum+" sum "+"CARRY "+carry);
			l1 = l1.next;
			temp = temp.next;
		}
		
		while(l2 != null){
			int val = l2.val + carry;
			temp.next = new ListNode(val % 10);
			carry = val / 10;
			System.out.println(sum+" sum "+"CARRY "+carry);
			l2 = l2.next;
			temp = temp.next;
		}
		
		
		if(carry > 0)
			temp.next = new ListNode(carry);
		
		
		return result.next;

	}

}
