package com.example.practice;

public class MyHashMap {

	private Node[] table;
	private int capacity = 4;

	MyHashMap() {
		table = new Node[capacity];
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
		MyHashMap map = new MyHashMap();
		map.put("1", "cat");
		map.put("2", "dog");
		map.put("3", "elephant");
		map.put("3", "x");
		map.put("3", "y");
		map.put("3", "z");
		map.display();
		map.delete("3");
		map.display();
		// System.out.println(map.get("2"));

	}

	private void delete(String key) {

		int hash = getHashCode(key);
		Node temp = table[hash];
		if (temp != null) {
			if (temp.key.equals(key)) {
				table[hash] = table[hash].next;
				return;
			} else {
				Node prev = temp;
				Node curr = prev.next;
				while (curr != null) {
					if (curr.key.equals(key)) {
						prev.next = curr.next;
						return;
					}

					curr = curr.next;
					prev = prev.next;
				}
			}
		}

	}

	private String get(String key) {

		int hash = getHashCode(key);
		Node n = table[hash];

		while (n != null) {
			if (n.key.equals(key))
				return n.value;
			n = n.next;
		}

		return null;
	}

	private void display() {

		for (int i = 0; i < table.length; i++) {
			Node t = table[i];
			while (t != null) {
				System.out.println(t.value);
				t = t.next;
			}
		}

	}

	public void put(String key, String value) {

		// calculate hash
		int hash = getHashCode(key);
		Node n = new Node(key, value);
		if (table[hash] == null) {
			table[hash] = n;
		} else {
			Node prev = table[hash];
			if (prev.key.equals(key)) {
				prev.value = value;
				return;
			}
			Node curr = prev.next;
			while (curr != null) {

				if (curr.key.equals(key)) {
					curr.value = value;
					return;
				}

				curr = curr.next;
				prev = prev.next;
			}

			prev.next = n;
		}
	}

	private int getHashCode(String key) {

		return key.hashCode() % capacity;
	}
}
