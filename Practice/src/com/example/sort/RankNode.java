package com.example.sort;

public class RankNode {

	RankNode left, right;
	RankNode root;
	int leftSize;
	int data;

	RankNode(int data) {
		this.data = data;
	}

	void track(int val) {

		if (root == null)
			root = new RankNode(val);
		else
			root.insert(val);
	}

	private void insert(int val) {

		if (val <= data) {
			if (left == null)
				left = new RankNode(val);
			else
				left.insert(val);
			leftSize++;
		} else {
			if (right == null)
				right = new RankNode(val);
			else
				right.insert(val);
		}
	}
	
	
	public int getNodeRank(int val){
		return root.getRank(val);
	}

	public int getRank(int val) {

		if (val == data)
			return leftSize;
		else if (val < data) {
			if (left == null)
				return -1;
			else 
				left.getRank(val);
		} else {

			int rightSize = right == null ? -1 : right.getRank(val);
			if (rightSize == -1)
				return -1;
			else
				return leftSize + 1 + rightSize;
		}
		return -1;

	}

	public static void main(String[] args) {

		RankNode node = new RankNode(20);
		node.track(15);
		node.track(25);
		node.track(10);
		
		node.track(5);
		node.track(13);
		node.track(25);
		node.track(23);
		node.track(24);
		
		System.out.println(node.getNodeRank(15));
	}

}
