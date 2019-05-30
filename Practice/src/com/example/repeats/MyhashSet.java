package com.example.repeats;

public class MyhashSet {

	int capacity = 1 << 4;
	Node[] table = null;

	MyhashSet() {
		table = new Node[capacity];
	}

	public static class Node {
		Node next;
		int key;

		Node(int key) {
			this.key = key;
		}
	}

	public static void main(String[] args) {

		MyhashSet hashmap = new MyhashSet();
		hashmap.add(1);

		hashmap.remove(1);
		hashmap.contains(1);
	}

	private void remove(int key) {

		int hashcode = getHashcode(key);
		Node n = table[hashcode];

		if (n == null)
			return;

		if (n.key == key) {
			table[hashcode] = table[hashcode].next;
			return;
		}

		Node curr = n;
		Node next = n.next;

		while (next != null) {
			if (next.key == key) {
				curr.next = next.next;
			}
			curr = next;
			next = next.next;
		}
	}

	private boolean contains(int key) {

		int hashcode = getHashcode(key);
		Node n = table[hashcode];

		if (n == null)
			return false;

		while (n != null) {
			if (n.key == key)
				return true;
			else
				n = n.next;
		}
		return false;
	}

	private void add(int key) {

		System.gc();
		int hashcode = getHashcode(key);
		Node newNode = new Node(key);

		if (table[hashcode] == null) {
			table[hashcode] = newNode;
		} else {
			Node curr = table[hashcode];
			Node prev = null;

			while (curr != null) {

				if (curr.key == key) {
					return;
				}
				prev = curr;
				curr = curr.next;
			}
			prev.next = newNode;
		}

	}

	private int getHashcode(int key) {
		return Math.abs(String.valueOf(key).hashCode()) % capacity;
	}

}
