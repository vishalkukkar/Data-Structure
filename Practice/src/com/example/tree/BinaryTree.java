package com.example.tree;

public class BinaryTree {

	public static class Node {

		Node left;
		Node right;
		int val;

		public Node(int val) {
			this.val = val;
		}
	}

	Node root;

	private void add(int val) {
		root = addRecursive(root, val);
	}

	private Node addRecursive(Node curr, int val) {
		if (curr == null)
			return new Node(val);
		else if (val < curr.val)
			curr.left = addRecursive(curr.left, val);
		else
			curr.right = addRecursive(curr.right, val);
		return curr;
	}

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.add(10);
		b.add(20);
		b.add(5);
		b.add(4);
		b.add(6);
		b.add(25);
		b.add(15);
		b.display();
	}

	private void display() {
		inorderTraversal(root);
	}

	private void inorderTraversal(Node root) {
		
		if(root != null){
			inorderTraversal(root.left);
			System.out.println(" "+root.val);
			inorderTraversal(root.right);
		}
		
	}

}
