package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.util.Util;

public class DetectCycleGraphSolution {

	static class DetectCycleGraph {
		private int V;
		private List<List<Integer>> edges;

		DetectCycleGraph(int n) {
			this.V = n;
			System.out.println(n);
			edges = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				edges.add(new ArrayList<>());
			}
		}

		public DetectCycleGraph() {
		}

		private void addEdge(int i, int j) {
			edges.get(i).add(j);
		}

		List<Integer> l = new ArrayList<>();

		public int[] isCycle(DetectCycleGraph graph) {

			boolean[] visited = new boolean[this.V];
			boolean[] curRec = new boolean[this.V];
			System.out.println(V);
			for (int i = 0; i < this.V; i++) {
				System.out.println("i " + i);
				if (isCycleUtil(visited, curRec, i))
					return new int[0];
			}

			System.out.println("list" + Util.print(l));

			int[] res = new int[V];
			int index = 0;
			for (Integer i : l) {
				res[index] = i;
				index++;
			}

			return res;
		}

		public boolean isCycleUtil(boolean[] visited, boolean[] curRec, int i) {

			if (visited[i] == false) {

				visited[i] = true;
				curRec[i] = true;

				List<Integer> neighbours = edges.get(i);
				for (Integer v : neighbours) {

					if (!visited[v] && isCycleUtil(visited, curRec, v))
						return true;
					else if (curRec[v])
						return true;
				}
				l.add(new Integer(i));
			}

			curRec[i] = false;

			return false;
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		DetectCycleGraph graph = new DetectCycleGraph(numCourses);
		for (int i = 0; i < prerequisites.length; i++) {
			int[] sub = prerequisites[i];
			graph.addEdge(sub[0], sub[1]);
		}
		return graph.isCycle(graph);

	}

	public static void main(String[] args) {

		DetectCycleGraph graph = new DetectCycleGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		// 0 --> 1 --> 2 --
		System.out.println(Arrays.toString(graph.isCycle(graph)));
	}
}
