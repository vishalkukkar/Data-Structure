package com.example.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int data) {
		this.val = data;
	}

	public void insert(int value) {
		if (value <= val) {
			if (left == null)
				left = new TreeNode(value);
			else
				left.insert(value);
		} else {
			if (right == null)
				right = new TreeNode(value);
			else
				right.insert(value);
		}
	}

	public void displayInOrder() {
		if (left != null)
			left.displayInOrder();
		System.out.println(val);
		if (right != null)
			right.displayInOrder();
	}

	private Boolean find(int value) {
		if (value <= val) {
			if (left != null && left.val == value)
				return true;
			else {
				if (left != null)
					left.find(value);
			}

		} else {
			if (right != null && right.val == value)
				return true;
			else {
				if (right != null)
					right.find(value);
			}

		}
		return false;
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper m = new ObjectMapper();
		TreeNode root = new TreeNode(100);
		root.insert(45);
		root.insert(64);
		root.insert(58);
		root.insert(68);
		root.insert(67);

		// TreeNode root2 = new TreeNode(2);
		// root.insert(3);
		// root.insert(-7);
		// root.insert(11);
		// root.insert(1);

		// levelOrderPrint(root);
		// System.out.println(m.writeValueAsString(levelOrder(root)));
		// TreeNode resultNode = mergeTrees(root, root2);

		System.out.println(m.writeValueAsString(rightSideView(root)));
	}

	/*
	 * https://leetcode.com/problems/binary-tree-right-side-view/description/
	 */
	public static List<Integer> rightSideView(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		queue.add(root);
		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {

				TreeNode top = queue.remove();
				if (i == 0)
					result.add(top.val);
				if (top.right != null)
					queue.add(top.right);
				if (top.left != null)
					queue.add(top.left);
			}

		}
		return result;
	}

	/*
	 * https://leetcode.com/problems/merge-two-binary-trees/description/
	 */
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null)
			return t2;

		if (t2 == null)
			return t1;

		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);
		return node;
	}

	/*
	 * https://leetcode.com/problems/binary-tree-level-order-traversal/
	 * description/
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();

		LinkedList<TreeNode> curr = new LinkedList<>();
		LinkedList<TreeNode> next = new LinkedList<>();

		if (root == null)
			return list;

		curr.add(root);

		while (!curr.isEmpty()) {

			TreeNode node = curr.remove();

			if (node.left != null)
				next.add(node.left);
			if (node.right != null)
				next.add(node.right);

			subList.add(node.val);

			if (curr.isEmpty()) {
				curr = next;
				next = new LinkedList<>();
				list.add(subList);
				subList = new ArrayList<>();
			}
		}

		return list;

	}

	public static void levelOrderPrint(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			TreeNode curr = queue.remove();
			System.out.println(curr.val);

			if (curr.left != null)
				queue.add(curr.left);
			if (curr.right != null)
				queue.add(curr.right);
		}

	}

}
