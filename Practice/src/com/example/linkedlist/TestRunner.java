package com.example.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestRunner {

	ReverseLinkedList myClass = new ReverseLinkedList();

	@Test
	public void testReverseListNull() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode result = myClass.reverseList(head);
		Assert.assertNotNull(result);

	}

	@Test
	public void testReverseListContent() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

		// create map list
		ListNode temp = head;
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while (temp != null) {
			list.add(temp.value);
			temp = temp.next;
			count++;

		}
		ListNode result = myClass.reverseList(head);

		// compare val
		Boolean flag = true;
		while (result != null && head != null && count >= 0) {
			count--;
			System.out.println("count " + count);
			System.out.println(list.get(count) + " " + result.value);
			if (list.get(count) != result.value) {
				flag = false;
				break;
			}
			result = result.next;
		}
		assertTrue(flag);
	}

	@Test
	public void testReverseListLength() {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode result = myClass.reverseList(head);
		Assert.assertNotNull(result);
	}

	@Test
	public void testReverseListWithOneElement() {

		ListNode head = new ListNode(1);
		head.next = null;
		ListNode result = myClass.reverseList(head);
		Assert.assertNotNull(result);
		while (result != null) {
			assertEquals(result.value, 1);
			result = result.next;
		}
	}

	@Test
	public void testReverseListWithNull() {

		ListNode head = null;
		ListNode result = myClass.reverseList(head);
		Assert.assertNull(result);
	}
}
