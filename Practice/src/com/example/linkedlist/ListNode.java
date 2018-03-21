package com.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}
	
	ListNode(int val) {
		this.val = val;
		next = null;
		
	}
	public static void main(String args[]){
		
		
		int[] array = {1,2,3,4,5,6};
		ListNode res = createLinkedList(array);
		
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		
	}
	private static ListNode createLinkedList(int[] array) {
		
		ListNode l = new ListNode(0);
		ListNode temp = l;
		for (int i = 0; i < array.length; i++) {
			temp.next = new ListNode(array[i]);
			temp = temp.next;
		}
		return l.next;
	}
}
