package com.example.java;

public class CustomHashMap {

	Node[] table;
	int capacity = 4;

	public CustomHashMap() {
		this.table = new Node[capacity];
	}

	private int hashCode(String key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {
		CustomHashMap map = new CustomHashMap();
		map.put("1", "test1");
		map.put("2", "test2");
		map.put("4", "test3");

		System.out.println(map.get("2"));
		map.delete("4");
		map.display();
	}

	private void delete(String key) {
		int hashCode = hashCode(key);
		Node curr = table[hashCode];
		Node prev = null;
		if (curr == null)
			return;

		while (curr != null) {

			if (curr.key.equals(key)) {
				if (prev == null) {
					table[hashCode] = table[hashCode].next;
					return;
				} else {
					prev.next = curr.next;
					return;
				}
			}
			prev = curr;
			curr = curr.next;
		}
	}

	private String get(String key) {

		int hashCode = hashCode(key);
		Node curr = table[hashCode];

		if (curr == null)
			return null;

		while (curr != null) {
			if (curr.key.equals(key))
				return curr.value;
			curr = curr.next;
		}
		return null;
	}

	private void display() {
		for (int i = 0; i < table.length; i++) {
			Node curr = table[i];
			while (curr != null) {
				System.out.println("key " + curr.key + " val " + curr.value);
				curr = curr.next;
			}
		}
	}

	public void put(String key, String value) {
		if (key == null)
			return;

		int hash = hashCode(key);
		System.out.println(hash);
		Node newNode = new Node(key, value);

		if (table[hash] == null) {
			table[hash] = newNode;
		} else {

			Node curr = table[hash];
			Node prev = null;

			while (curr != null) {

				if (key.equals(curr.key)) {
					curr.value = value;
					return;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			prev.next = newNode;
		}
	}

	static class Node {
		Node next;
		String key;
		String value;

		Node() {
		}

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

}
