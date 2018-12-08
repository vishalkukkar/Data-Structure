package com.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Soltuion {

	public static class GraphNode {

		GraphNode() {
		}

		public int value;
		public Boolean isVisited;
		public GraphNode[] adjecentList;

		public GraphNode(int i, GraphNode[] adjecentList) {
			this.value = i;
			this.adjecentList = adjecentList;
			this.isVisited = false;
		}

		public GraphNode(int i) {
			this.value = i;
		}

	}

	public static void main(String[] args) {

		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);

		n1.adjecentList = new GraphNode[] { n2, n3 };
		n2.adjecentList = new GraphNode[] { n3, n4 };
		n3.adjecentList = new GraphNode[] { n4, n5, n2 };
		n4.adjecentList = new GraphNode[] { n5, n6 };

		n1.isVisited = false;
		n2.isVisited = false;
		n3.isVisited = false;
		n4.isVisited = false;
		n5.isVisited = false;
		n6.isVisited = false;

		System.out.println(searchNode(n4, n2));

	}

	private static Boolean searchNode(GraphNode root, GraphNode n6) {

		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		q.add(root);
		root.isVisited = true;

		while (q.peek() != null) {
			GraphNode temp = q.poll();
			if (temp.adjecentList == null)
				continue;
			for (GraphNode x : temp.adjecentList) {
				if (!x.isVisited) {
					x.isVisited = true;
					if (n6 == x)
						return true;

					q.offer(x);
				}
			}
		}

		return false;
	}
	
	

}
