package com.example.java;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class MyHashMap<K, V> {

	private List<List<MyNode>> table = null;
	private Integer capacity = null;

	MyHashMap(Integer value) {

		this.capacity = value;

		// add number of array list as per mentioned capacity
		// so we can directly jump to location and add elements to it
		table = new ArrayList<>(capacity);
		for (Integer i = 0; i < capacity; i++) {
			table.add(new ArrayList<MyNode>());
		}
	}

	private void put(K key, V value) {

		// calculate hash
		int position = key.toString().hashCode() % capacity;
		List<MyNode> list = table.get(position);
		MyNode<K, V> node = new MyNode<K, V>(key, value);

		if (list == null) {
			list = new ArrayList<>();
			list.add(node);
			table.add(position, list);
		} else {

			// need this flag to check if key is already present in the list
			// if yes then just change the value of the Node
			Boolean flag = true;
			for (MyNode entry : list) {
				if (entry.key.equals(key)) {
					entry.value = value;
					flag = false;
				}
			}

			// if it it's not present add new node to the list
			if (flag) {
				list.add(node);
			}

			table.add(position, list);
		}
	}

	private Object get(K key) {
		// calculate hash
		int position = key.toString().hashCode() % capacity;
		List<MyNode> temp = table.get(position);

		if (temp == null) {
			return null;
		} else {
			for (MyNode entry : temp) {
				if (entry.key.equals(key))
					return entry.value;
			}
		}
		return null;
	}

	private void display() {

		for (List<MyNode> entry : table) {
			System.out.println("\n");
			for (MyNode t : entry) {
				System.out.println("key " + t.key + " value " + t.value);
			}
		}

	}

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>(4);
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		map.put("3", "Z");

		System.out.println(map.get("2").toString());
		System.out.println(map.get("1").toString());
		System.out.println(map.get("3").toString());
		// map.display();
	}

	public static class MyNode<K, V> {
		public K key;
		public V value;

		MyNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
