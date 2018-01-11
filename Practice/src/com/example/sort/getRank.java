package com.example.sort;

public class getRank {

	Node root;

	void track(int d) {
		if (root == null)
			root = new Node(d);
		else
			root.insert(d);

	}

	int getRankOfNumber(int n) {
		return root.getRank(n);
	}

	public static class Node {

		int left_size = 0;
		Node left, right;
		int data;

		public Node(int d) {
			this.data = d;

		}

		public void insert(int d) {
			if (d <= data) {
				if (left != null)
					left.insert(d);
				else
					left = new Node(d);
				left_size++;
			} else {
				if (right != null)
					right.insert(d);
				else
					right = new Node(d);
			}
		}

		public int getRank(int d) {
			System.out.println("data "+data);
			System.out.println("size"+left_size);
			if (data == d) {
				return left_size;
			} else if (d < data) {
				if (left == null)
					return -1;
				else
					left.getRank(d);
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1)
					return -1;
				else
					return left_size + 1 + right_rank;
			}
			return -1;

		}
	}

	public static void main(String[] args) {

		getRank g = new getRank();
		g.track(20);
		g.track(15);
		g.track(10);
		System.out.println(g.getRankOfNumber(15));
	}
}
