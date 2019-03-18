package com.example.java8;

public class HashMap<K, V> {

	Node[] nodes;
	int size = 10;
	
	HashMap(){
		nodes = new Node[10];
	}
	
	private V get(K key) {
		
		int bucketNo = key.hashCode() % size;
		Node<K,V> curr = nodes[bucketNo];
		
		if(curr == null){
			return null;
		}else{
			
			while(curr != null){
				if(curr.key.equals(key)){
					return curr.value;
				}
				curr = curr.next;
			}
		}

		return null;
	}

	private void put(K key, V value) {
		
		int bucketNo = key.hashCode() % size;
		
		Node curr = nodes[bucketNo];
		Boolean needToUpdate = true;
		if(curr == null){
			nodes[bucketNo] = new Node<K, V>(key,value);
		}else{
			Node<K, V> head = nodes[bucketNo];
			Node<K,V> prev = null;
			while(head != null){
				
				if(head.key.equals(key)){
					head.value = value;
					needToUpdate = false;
					break;
				}
				prev = head;
				head = head.next;
			}
			
			if(needToUpdate)
				prev.next = new Node<K, V>(key,value);
		}
		
	}	

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(2, 2);
		map.put(1, 5);
		map.put(6, 6);
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(6));
	}


	private char[] display() {
		
		for(Node n : nodes){
			
			while(n != null){
				n = n.next;
			}
		}
		return null;
	}


	public static class Node<K, V> {

		Node next;
		K key;
		V value;

		Node() {

		}

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

}
