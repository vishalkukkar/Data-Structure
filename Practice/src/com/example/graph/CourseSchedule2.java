package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {

	public static class GraphNode {

		int n;
		List<Integer> adj[];
		boolean isCyclic;

		GraphNode(int size) {
			n = size;
			adj = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				adj[i] = new LinkedList<>();
			}

		}

		public void addEdge(int i, int j) {
			adj[i].add(j);
		}

		public int[] run() {
			boolean[] visited = new boolean[n];
			boolean[] rec = new boolean[n];

			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				if (!visited[i] && !hasCycle(i, visited, list, rec))
					return new int[0];
			}

			int[] res = new int[n];
			int index = 0;
			for (Integer i : list) {
				res[index] = i;
				index++;
			}

			return res;

		}

		private boolean hasCycle(int v, boolean[] visited, List<Integer> list, boolean[] res) {

			res[v] = true;
			visited[v] = true;

			Iterator<Integer> node = adj[v].iterator();
			Integer curr;
			while (node.hasNext()) {
				curr = node.next();
				if (!visited[curr]) {
					if (!hasCycle(curr, visited, list, res))
						return false;
				} else if(visited[curr]) {
					return false;
				}

			}
			res[v] = false;
			list.add(new Integer(v));
			return true;
		}

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		GraphNode graph = new GraphNode(numCourses);
		for (int i = 0; i < prerequisites.length; i++) {
			int[] sub = prerequisites[i];
			graph.addEdge(sub[0], sub[1]);
		}
		return graph.run();

	}

	public static void main(String args[]) {

		int[][] prerequisites = { { 1, 0 } };
		int numCourses = 2;
		int[] res = new CourseSchedule2().findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(res));
	}

}
