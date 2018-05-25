package com.example.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

	public static class DoublyLinkedList {
		DoublyLinkedList next;
		DoublyLinkedList prev;
		Integer key;
		Integer val;
	}

	Integer capacity;
	DoublyLinkedList head;
	DoublyLinkedList tail;
	Map<Integer, DoublyLinkedList> map = new HashMap<Integer, DoublyLinkedList>();

	public LRUCache1(int capacity) {
		this.capacity = capacity;
		head = new DoublyLinkedList();
		tail = new DoublyLinkedList();

		head.next = tail;
		tail.prev = head;

	}

	private void put(int key, int val) {

		DoublyLinkedList node = map.get(key);

		if (node == null) {
			
			capacity--;
			node = new DoublyLinkedList();
			node.key = key;
			node.val = val;
			
			map.put(key, node);
			moveToHead(node);
			
			if(capacity < 0){
				
				DoublyLinkedList temp = removeTailnode();
				map.remove(temp.key);
				capacity++;
			}
		}else{
			
			node.val = val;
			map.put(key, node);
			moveToHead(node);
		}
	}

	private DoublyLinkedList removeTailnode() {
		DoublyLinkedList temp = tail.prev;
		remove(temp);
		return temp;
	}

	private void remove(DoublyLinkedList temp) {
		
		DoublyLinkedList p = temp.prev;
		DoublyLinkedList q = temp.next;
		
		p.next = q;
		q.prev = p;
		
		
	}

	private void moveToHead(DoublyLinkedList node) {
		
		node.prev = head;
		node.next = head.next;
		
		head.next = node;
		node.next.prev = node;
		
	}

	public static void main(String[] args) {

		LRUCache1 lru = new LRUCache1(2);
		lru.put(2, 2);
		lru.put(1, 3);
		
		System.out.println(lru.get(1));

	}

	private Integer get(int key) {
		
		DoublyLinkedList node = map.get(key);
		
		remove(node);
		moveToHead(node);
		
		return node.val;
	}

}
