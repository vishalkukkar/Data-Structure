package com.example.tree;

public class RankNode {

	RankNode left;
	RankNode right;
	int data;
	int leftSize;

	public RankNode(int d) {
		this.data = d;
	}

	private int getRank(RankNode root,int d) {

		if(root.data == d) return root.leftSize;
		else if(d <= root.data)
			return getRank(root.left, d);
		else
			return root.leftSize + 1 + getRank(root.right, d);
			
		
	}

	private void insert(int d) {

		if (d <= data) {

			if (left == null)
				left = new RankNode(d);
			else
				left.insert(d);
			leftSize++;
		} else {
			if (right == null)
				right = new RankNode(d);
			else
				right.insert(d);
		}
	}

	public static void main(String[] args) {

		RankNode node = new RankNode(20);
		node.insert(20);
		node.insert(15);
		node.insert(10);
		node.insert(13);
		node.insert(5);
		node.insert(25);
		node.insert(23);
		node.insert(24);

		System.out.println(node.getRank(node,5));
		System.out.println(	node.getRank(node,23));
		System.out.println(node.getRank(node,24));
	}
}
