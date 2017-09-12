package com.cake.com;

public class HashMap {

	Node head;

	public class Node {
		Node next;
		String key;
		String value;

		Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	public String delete(String key) {

		if (head == null)
			return null;

		if (head.key.equals(key))
			head = null;

		Node temp1 = head;
		Node temp = head.next;
		while (temp1 != null && temp != null) {

			if (temp.key.equals(key)) {
				temp1.next = temp.next;
			}

			temp1 = temp1.next;
			temp = temp.next;
		}
		
		
		return null;
	}

	public void display() {

		while (head != null) {
			System.out.println("key " + head.key + " value " + head.value);
			head = head.next;
		}
	}

	public void put(String key, String value) {

		if (head == null)
			head = new Node(key, value);
		else {
			Node temp = head;
			while (temp != null) {

				if (temp.key.equals(key)) {
					temp.value = value;
					break;
				}

				if (temp.next == null) {
					temp.next = new Node(key, value);
					break;
				}
				temp = temp.next;
			}
		}

	}

	public static void main(String[] args) {

		HashMap map = new HashMap();
		map.put("1", "abc");
		map.put("2", "xyz");
		map.put("3", "pqr");
		map.put("3", "stq");
		
		map.delete("2");
		

		map.display();
		
	

	}

}
