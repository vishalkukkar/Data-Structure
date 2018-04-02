package com.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
	}

	public void insert(int x) {

		if (x <= this.val) {
			if (left == null)
				left = new TreeNode(x);
			else
				left.insert(x);
		} else {
			if (right == null)
				right = new TreeNode(x);
			else
				right.insert(x);
		}
	}

	private void inorderTraversal() {

		if (left != null)
			left.inorderTraversal();
		System.out.print(this.val + "  ");
		if (right != null)
			right.inorderTraversal();
	}

	private void preTraversal() {

		System.out.print(this.val + "  ");
		if (left != null)
			left.inorderTraversal();
		if (right != null)
			right.inorderTraversal();
	}

	private void postTraversal() {

		if (left != null)
			left.inorderTraversal();
		if (right != null)
			right.inorderTraversal();

		System.out.print(this.val + " ");
	}

	int result;

	public static void main(String[] args) {

		
		HashMap<Set<Integer>,Integer> map = new HashMap<>();
		
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		map.put(s1, 1);
		map.put(s2, 2);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(map.get(s1));
		System.out.println(map.get(s2));
		
		TreeNode n = new TreeNode(50);
		n.insert(20);
		n.insert(60);
		n.insert(10);
		n.insert(70);
		n.insert(30);

		/*
		 * n.inorderTraversal(); System.out.println("inorder order");
		 * n.preTraversal(); System.out.println("pre order"); n.postTraversal();
		 * System.out.println("post order");
		 * 
		 * n.zigzagOrderTraversal();
		 */

		//System.out.println(n.searchNearestNode(61, n));

	}

	private Integer searchNearestNode(int target, TreeNode root) {

		int min = Integer.MAX_VALUE;
		search(target,min,root);
		return result;
	}

	private void search(int target, int min, TreeNode root) {

		if (root == null)
			return;

		if (Math.abs(root.val - target) < min) {

			min = Math.abs(root.val - target);
			result = root.val;
		}

		if (target < root.val)
			search(target, min, root.left);
		else
			search(target, min, root.right);

	}

	private void zigzagOrderTraversal() {

		int count = 0;

		LinkedList<TreeNode> queue = new LinkedList<>();

		queue.add(this);

		while (!queue.isEmpty()) {

			int size = queue.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.remove();
				list.add(curr.val);

				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);

			}

			if (count % 2 == 0) {

				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + " ");
				}
			} else {
				for (int i = list.size() - 1; i >= 0; i--) {
					System.out.println(list.get(i) + " ");
				}
			}

			count++;
		}

	}
	
}
