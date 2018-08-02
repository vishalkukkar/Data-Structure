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

		//ListNode res = mergeTwoList(head2, head);
		ListNode res = mergeKLists(lists);
		System.out.println("\n\nAns : \n");
		while (res != null) {
			System.out.print(res.val+" ");
			res = res.next;
		}
	}
	
	private static void display(List<ListNode> lists) {
		
		for (int i = 0; i < lists.size(); i++) {
			ListNode res = lists.get(i);
			System.out.println();
			while (res != null) {
				System.out.print(res.val+" ");
				res = res.next;
			}
		}
	}
	
	public static ListNode mergeKLists(List<ListNode> lists) {
		
		  if(lists == null || lists.size() == 0) return null;
		  
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		
		PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
		for(ListNode list : lists){
			if (list != null)
				queue.add(list);
		}
		
		while(!queue.isEmpty()){
			
			ListNode node = queue.remove();
			curr.next = node;
			curr = curr.next;
			node = node.next;
			
			if(node != null)
				queue.add(node);
		}
		
		return head.next;
		
	}

	/*public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.size(), (l1,l2) -> l1.val - l2.val);
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }*/

	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {

		if(l1 == null && l2 == null)
			return null;
		ListNode res = new ListNode(0);
		ListNode temp = res;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			temp = temp.next;
		}

		while (l1 != null) {
			temp.next = new ListNode(l1.val);
			temp = temp.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			temp.next = new ListNode(l2.val);
			temp = temp.next;
			l2 = l2.next;
		}

		return res.next;
	}
}
