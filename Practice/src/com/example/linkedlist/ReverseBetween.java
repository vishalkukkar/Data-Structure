package com.example.linkedlist;

public class ReverseBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode prev = temp;
		int count = 1;

		ListNode p = head;
		while (p != null) {
			count++;

			if (count == m) {
				break;
			}

			prev = p;
			p = p.next;
		}

		ListNode t = prev;
		while (p != null) {
			count++;
			if (count == n) {
				break;
			}

			prev = p;
			p = p.next;

		}

		prev = reverse(t, prev.next);
		p.next = prev;
		return temp.next;
	}

	public ListNode reverse(ListNode prev, ListNode next) {

		ListNode last = prev.next;
		ListNode curr = last.next;

		while (curr != next) {
			last.next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			curr = last.next;
		}

		return last;

	}

}
