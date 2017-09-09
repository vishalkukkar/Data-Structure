package com.example.tree;

public class Node {

	Node left;
	Node right;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
	
	public void insert(int value){
		
		 if(value <= data){
			if(left == null){
				left = new Node(value);
			}else{
				left.insert(value);
			}
		}else{
			if(right == null){
				right = new Node(value);
			}else{
				right.insert(value);
			}
		}
		
	}
	
	public void displayInOrder(){
		if(left != null)
			left.displayInOrder();
		System.out.println(data);
		if(right != null)
			right.displayInOrder();
	}
	
	private Boolean find(int value) {
		
		if(data == value){
			return true;
		}else if(value <= data ){
			if(left == null)
				return false;
			else
				return left.find(value);
		}else{
			if(right == null)
				return false;
			else
				return right.find(value);
		}
		
	}

	public static void main(String[] args) {
		
		Node root = new Node(55);
		root.insert(50);
		root.insert(60);
		root.displayInOrder();
		
		System.out.println(root.find(8));
	}

}
