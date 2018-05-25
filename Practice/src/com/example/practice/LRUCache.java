package com.example.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));// returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4));// returns 4

	}

	public static class DoublyLinkedList {

		int key;
		int value;
		DoublyLinkedList prev;
		DoublyLinkedList next;

		DoublyLinkedList(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	int Capacity;
	DoublyLinkedList head = null;
	DoublyLinkedList tail = null;
	Map<Integer, DoublyLinkedList> map = new HashMap<>();

	LRUCache(int capacity) {
		this.Capacity = capacity;
	}

	private void remove(DoublyLinkedList node) {

		DoublyLinkedList prev = node.prev;
		DoublyLinkedList next = node.next;

		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null)
			next.prev = prev;
		else
			tail = prev;

	}

	private void addToHead(DoublyLinkedList node) {

		node.next = head;
		node.prev = null;

		// check if head is null
		if (head != null) {
			head.prev = node;
			head = node;
		}

		if (tail == null)
			tail = node;

	}

	private void put(int key, int value) {
		DoublyLinkedList node = map.get(key);
		if (node == null) {
			// create new node
			node = new DoublyLinkedList(key, value);
			if (map.size() >= Capacity) {
				map.remove(tail.key);
				remove(tail);
				addToHead(node);
			} else {
				addToHead(node);
			}
			map.put(key, node);
		} else {
			// node already exist
			// update node vaue and move to head
			map.put(key, node);
			remove(node);
			addToHead(node);
		}
	}

	private Integer get(int key) {

		DoublyLinkedList node = map.get(key);

		if (node == null)
			return -1;
		else {
			remove(node);
			addToHead(node);
		}

		return node.value;

	}

}
