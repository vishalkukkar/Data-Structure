package com.example.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
		TreeNode root = new TreeNode(40);
		root.insert(20);
		root.insert(10);
		root.insert(30);
		root.insert(60);
		root.insert(50);
		root.insert(70);

		// TreeNode root2 = new TreeNode(2);
		// root.insert(3);
		// root.insert(-7);
		// root.insert(11);
		// root.insert(1);

		levelOrderPrint(root);
		levelOrderPrintEasy(root);
		// System.out.println(m.writeValueAsString(levelOrder(root)));
		// TreeNode resultNode = mergeTrees(root, root2);
		// System.out.println(m.writeValueAsString(rightSideView(root)));
		// System.out.println(m.writeValueAsString(iterativeInorderTraversal(root)));
	}

	// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;
		else {

			int ldepth = maxDepth(root.left);
			int rdepth = maxDepth(root.right);

			if (ldepth > rdepth)
				return ldepth + 1;
			else
				return rdepth + 1;
		}
	}

	// https://leetcode.com/problems/binary-search-tree-iterator/description/
	public class BSTIterator {

		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			TreeNode node = root;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			if (stack.isEmpty())
				return false;
			return true;
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode node = stack.pop();
			int val = node.val;

			if (node.right != null) {
				node = node.right;
				stack.push(node);
				while (node.left != null) {
					stack.push(node.left);
					node = node.left;
				}
			}

			return val;

		}
	}

	// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
	private static List<Integer> iterativeInorderTraversal(TreeNode root) {

		List<Integer> iterative = new ArrayList<>();
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();

		// add all the nodes on the left first
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			node = stack.pop();
			iterative.add(node.val);

			// check if above node has right child
			// if yes add all left child of this right child
			if (node.right != null) {
				node = node.right;

				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}

		}

		return iterative;
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

	public static void levelOrderPrint1(TreeNode root) {

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

	public static void levelOrderPrint(TreeNode root) {

		List<Integer> subList = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<>();

		LinkedList<TreeNode> curr = new LinkedList<>();
		LinkedList<TreeNode> next = new LinkedList<>();
		curr.add(root);

		while (!curr.isEmpty()) {
			TreeNode temp = curr.remove();
			subList.add(temp.val);
			System.out.print(temp.val);

			if (temp.left != null)
				next.add(temp.left);

			if (temp.right != null)
				next.add(temp.right);

			if (curr.isEmpty()) {
				System.out.println();
				curr = next;
				next = new LinkedList<>();
				list.add(subList);
				subList = new ArrayList<>();
			}

		}

	}

	public static void levelOrderPrintEasy(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println();
			for (int i = 0; i < size; i++) {
				TreeNode t = queue.remove();
				System.out.print(t.val);

				if (t.left != null)
					queue.add(t.left);
				if (t.right != null)
					queue.add(t.right);

			}
		}
	}

}
