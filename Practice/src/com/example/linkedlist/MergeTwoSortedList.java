package com.example.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoSortedList {

	public static void main(String[] args) {

		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		head.next.next = new ListNode(7);

		ListNode head2 = new ListNode(9);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(2);

		List<ListNode> lists = new ArrayList<>();
		lists.add(head);
		lists.add(head2);

		// ListNode res = mergeTwoList(head2, head);
		ListNode res = mergeKLists(lists);
		System.out.println("\n\nAns : \n");
		while (res != null) {
			System.out.print(res.value + " ");
			res = res.next;
		}
	}

	private static void display(List<ListNode> lists) {

		for (int i = 0; i < lists.size(); i++) {
			ListNode res = lists.get(i);
			System.out.println();
			while (res != null) {
				System.out.print(res.value + " ");
				res = res.next;
			}
		}
	}

	public static ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.size() == 0)
			return null;

		ListNode head = new ListNode(-1);
		ListNode curr = head;

		PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (ListNode list : lists) {
			if (list != null)
				queue.add(list);
		}

		while (!queue.isEmpty()) {

			ListNode node = queue.remove();
			curr.next = node;
			curr = curr.next;
			node = node.next;

			if (node != null)
				queue.add(node);
		}

		return head.next;

	}

	/*
	 * public static ListNode mergeKLists(List<ListNode> lists) { if
	 * (lists==null||lists.size()==0) return null;
	 * 
	 * PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.size(), (l1,l2)
	 * -> l1.val - l2.val); ListNode dummy = new ListNode(0); ListNode
	 * tail=dummy;
	 * 
	 * for (ListNode node:lists) if (node!=null) queue.add(node);
	 * 
	 * while (!queue.isEmpty()){ tail.next=queue.poll(); tail=tail.next;
	 * 
	 * if (tail.next!=null) queue.add(tail.next); } return dummy.next; }
	 */

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
				( l1, l2) -> Integer.valueOf(l1.value).compareTo(Integer.valueOf(l2.value)));

		for (ListNode l : lists) {

			if (l != null) {
				pq.add(l);
			}
		}
		
		ListNode head = new ListNode(0);
		ListNode temp = head;
		
		
		while(!pq.isEmpty()){
			
			ListNode p = pq.poll();
			ListNode t = p.next;
			p.next = null;
			
			temp.next = p;
			
			if(t != null){
				pq.add(t);
			}
		}
		
		
		return head.next;

	}

	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null)
			return null;
		ListNode res = new ListNode(0);
		ListNode temp = res;
		while (l1 != null && l2 != null) {
			if (l1.value <= l2.value) {
				temp.next = new ListNode(l1.value);
				l1 = l1.next;
			} else {
				temp.next = new ListNode(l2.value);
				l2 = l2.next;
			}
			temp = temp.next;
		}

		while (l1 != null) {
			temp.next = new ListNode(l1.value);
			temp = temp.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			temp.next = new ListNode(l2.value);
			temp = temp.next;
			l2 = l2.next;
		}

		return res.next;
	}
}
