package com.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.util.Util;

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

	Map<String, TreeNode> map = new HashMap<>();
	List<TreeNode> res = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		preOrder(root);
		return res;
	}

	public void preOrder(TreeNode root) {

		if (root != null) {
			String hash = serialize(root, new StringBuilder());
			if (map.containsKey(hash))
				res.add(root);
			else
				map.put(hash, root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public String serialize(TreeNode root, StringBuilder sb) {
		if (root == null)
			sb.append("# ");
		else{
			sb.append(root.val + " ");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		/*
		 * HashMap<Set<Integer>,Integer> map = new HashMap<>();
		 * 
		 * Set<Integer> s1 = new HashSet<>(); Set<Integer> s2 = new HashSet<>();
		 * map.put(s1, 1); map.put(s2, 2);
		 * 
		 * System.out.println(s1.hashCode()); System.out.println(s2.hashCode());
		 * 
		 * System.out.println(map.get(s1)); System.out.println(map.get(s2));
		 */

		String s = new String();

		TreeNode n = new TreeNode(1);
		n.insert(4);
		n.insert(3);
		n.insert(5);
		/*
		 * n.insert(70); n.insert(30); n.insert(80);
		 */

		/*List<Integer> res = n.boundaryOfBinaryTree(n);
		System.out.println(Util.print(res));*/
		// n.levelOrderNoExtraMemory(n);

		/*
		 * n.inorderTraversal(); System.out.println("inorder order");
		 * n.preTraversal(); System.out.println("pre order"); n.postTraversal();
		 * System.out.println("post order");
		 * 
		 * n.zigzagOrderTraversal();
		 */

		// System.out.println(n.searchNearestNode(61, n));

		// n.postTraversalIterative(n);
		// n.zigZagOrder(n);

		
		  String ser = n.serialize(n); 
		  System.out.println(ser); 
		  TreeNode node = n.deserialize(ser);
		 
		  n.levelOrderNoExtraMemory(node);
		 
	}

	/*public static List<Integer> boundaryOfBinaryTree(TreeNode root) {

		List<Integer> right = new ArrayList<>();
		LinkedList<Integer> left = new LinkedList<>();
		if (root == null)
			return right;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println();
			for (int i = 0; i < size; i++) {
				TreeNode t = queue.remove();
				if (i == 0) {
					left.add(t.val);
				}

				if (i != 0 && i != size - 1 && t.left == null && t.right == null) {
					left.add(t.val);
				}

				if (i != 0 && i == size - 1) {
					right.add(0, t.val);
				}

				if (t.left != null) {
					queue.add(t.left);
				}
				if (t.right != null) {
					queue.add(t.right);
				}

			}
		}

		left.addAll(right);
		return left;

	}*/

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		return serialize(root, new StringBuilder());
	}

	/*
	 * private String serialize(TreeNode root, StringBuilder sb) {
	 * 
	 * if (root == null) sb.append("# "); else { sb.append(root.val + " ");
	 * serialize(root.left, sb); serialize(root.right, sb); } return
	 * sb.toString().trim(); }
	 */

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if (data == null || data.length() == 0)
			return null;
		return deserialization(new StringTokenizer(data, " "));

	}

	private TreeNode deserialization(StringTokenizer stringTokenizer) {

		if (!stringTokenizer.hasMoreTokens())
			return null;

		String next = stringTokenizer.nextToken();
		if (next.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(next));
		root.left = deserialization(stringTokenizer);
		root.right = deserialization(stringTokenizer);

		return root;
	}

	private List<List<Integer>> zigZagOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.remove();

		}

		return res;
	}

	private void postTraversalIterative(TreeNode root) {
	}

	private void levelOrderNoExtraMemory(TreeNode root) {

		if (root == null)
			return;
		TreeNode temp = root;
		int height = getMaxheightOfTree(root);
		for (int i = 1; i <= height; i++) {
			printLevel(temp, i);
			System.out.println();
		}
	}

	private void printLevel(TreeNode root, int level) {

		if (root == null)
			return;
		else if (level == 1) {
			System.out.print(" " + root.val);
		} else {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}

	}

	private int getMaxheightOfTree(TreeNode root) {

		if (root == null)
			return 0;

		int left = getMaxheightOfTree(root.left);
		int right = getMaxheightOfTree(root.right);

		return 1 + Math.max(left, right);
	}

	private Integer searchNearestNode(int target, TreeNode root) {

		int min = Integer.MAX_VALUE;
		search(target, min, root);
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

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {

		List<Integer> res = new ArrayList<>();

		if (root == null)
			return res;
		res.add(root.val);
		leftTree(root.left, res);
		leaf(root, res);
		rightTree(root.right, res);

		return res;

	}

	public void leaf(TreeNode root,List<Integer> res){
        
        if(root != null){
            
            if(root.left == null && root.right == null)
                res.add(root.val);
            leaf(root.left,res);
            leaf(root.right,res);
        }
            
    }

	public void leftTree(TreeNode root,List<Integer> res){
        
		if(root == null)
			return;
		
        if(root.left != null){
            
            if(root.left.left != null && root.left.right != null){
                res.add(root.left.val);
                leftTree(root.left.left,res);
            }
        }else if(root.right != null){
            
            if(root.right.left != null && right.right != null){
               res.add(right.val);
               leftTree(right.left,res);
            }
        }
    }

	public void rightTree(TreeNode root,List<Integer> res){
        
		if(root == null)
			return;
		
          if(root.right != null){
              
              if(root.right.left != null && root.right.right != null){
                  res.add(root.right.val);
                  rightTree(root.right.right,res);
                }
        }
        else if(root.left != null){
            
             if(root.left.left != null && root.left.right != null){
                    res.add(root.left.val);
                    rightTree(root.left.right,res);
            }
        }
    }

}
