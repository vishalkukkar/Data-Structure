package com.example.tree;

public class ListNode {

	ListNode right;
	ListNode left;
	int data;

	ListNode() {
	};

	public ListNode(int data) {
		this.data = data;
	}

	void insert(int data) {
		if (data < this.data) {
			if (this.left == null) {
				this.left = new ListNode(data);
			} else {
				this.left.insert(data);
			}
		} else {

			if (right == null) {
				right = new ListNode(data);
			} else {
				right.insert(data);
			}

		}
	}

	private void displayInOrder() {
		if (left != null) {
			left.displayInOrder();
		}

		System.out.println(this.data);

		if (right != null)
			right.displayInOrder();
	}

	public static void main(String[] args) {

		ListNode n = new ListNode(10);
		n.insert(11);
		n.insert(9);

		n.displayInOrder();

	}

}
