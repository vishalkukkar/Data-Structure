package com.example.java;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

	public static class DoublyLinkedList {

		DoublyLinkedList prev;
		DoublyLinkedList next;
		int key;
		int value;
	}

	Map<Integer, DoublyLinkedList> map = new HashMap<>();
	DoublyLinkedList head;
	DoublyLinkedList tail;
	int capacity;

	public LRUCache(int capacity) {

		this.capacity = capacity;
		head = new DoublyLinkedList();
		tail = new DoublyLinkedList();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		DoublyLinkedList node = map.get(key);
		if (node == null)
			return -1;
		else {
			moveToHead(node);
			return node.value;
		}
	}

	public void put(int key, int value) {

		DoublyLinkedList node = map.get(key);

		// create new node after head if head is not null
		if (node == null) {

			DoublyLinkedList n = new DoublyLinkedList();
			n.key = key;
			n.value = value;
			map.put(key, n);
			addToHead(n);
			capacity = capacity - 1;
			if (capacity < 0) {
				DoublyLinkedList temp = popTail();
				map.remove(temp.key);
				capacity = capacity + 1;
			}


		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	private void addToHead(DoublyLinkedList node) {

		node.prev = head;
		node.next = head.next;

		head.next = node;
		node.next.prev = node;

	}

	private void removeNode(DoublyLinkedList node) {
		DoublyLinkedList t1 = node.prev;
		DoublyLinkedList t2 = node.next;

		t1.next = t2;
		t2.prev = t1;
	}

	private DoublyLinkedList popTail() {

		DoublyLinkedList t = tail.prev;
		this.removeNode(t);
		return t;

	}

	private void moveToHead(DoublyLinkedList node) {
		removeNode(node);
		addToHead(node);
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}
}
