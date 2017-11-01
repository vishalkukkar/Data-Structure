package com.example.repeats;

public class MyHashmap {

	int capacity = 4;
	Node[] table = null;

	MyHashmap() {
		table = new Node[4];
	}

	public static class Node {
		Node next;
		String key;
		String value;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {

		MyHashmap hashmap = new MyHashmap();
		hashmap.put("1", "vishal");
		hashmap.put("2", "krunal");
		hashmap.put("3", "kuntal");
		hashmap.put("4", "gaurang");
		hashmap.put("4", "abcd");

		hashmap.display();
		hashmap.delete("1");

		System.out.println("\n");
		hashmap.display();
		// System.out.println(hashmap.get("2"));
	}

	private void delete(String key) {

		int hashcode = getHashcode(key);
		Node n = table[hashcode];

		if (n == null)
			return;

		if (n.key.equals(key)) {
			table[hashcode] = table[hashcode].next;
			return;
		}

		Node curr = n;
		Node next = n.next;

		while (next != null) {
			if (next.key.equals(key)) {
				curr.next = next.next;
			}
			curr = next;
			next = next.next;
		}
	}

	private String get(String key) {

		int hashcode = getHashcode(key);
		Node n = table[hashcode];

		if (n == null)
			return null;

		while (n != null) {
			if (n.key.equals(key))
				return n.value;
			else
				n = n.next;
		}
		return null;
	}

	private void display() {

		for (int i = 0; i < table.length; i++) {
			Node curr = table[i];
			while (curr != null) {
				System.out.println(curr.value);
				curr = curr.next;
			}
		}

	}

	private void put(String key, String value) {

		// calculate hashcode for key
		int hashcode = getHashcode(key);
		Node newNode = new Node(key, value);

		if (table[hashcode] == null) {
			table[hashcode] = newNode;
		} else {
			Node curr = table[hashcode];
			// add node to end of the linked list
			Node prev = null;

			while (curr != null) {

				if (curr.key.equals(key)) {
					curr.value = value;
					return;
				}
				prev = curr;
				curr = curr.next;
			}
			prev.next = newNode;
		}

	}

	private int getHashcode(String key) {
		return Math.abs(key.hashCode()) % capacity;
	}

}
