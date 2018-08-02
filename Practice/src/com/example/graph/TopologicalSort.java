package com.example.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	int V;
	LinkedList<Integer> adj[];

	public TopologicalSort(int v) {
		this.V = v;
		adj = new LinkedList[v];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(int v1, int v2) {

		adj[v1].add(v2);
	}

	private void topologicalSort() {

		boolean[] visited = new boolean[this.V];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < V; i++)
			visited[i] = false;

		// visit all vertices
		for (int i = 0; i < V; i++) {
			if (visited[i] == false)
				topologicalSortUtil(i, stack, visited);
		}

		// topological sort print
		while (!stack.isEmpty())
			System.out.print(" " + stack.pop());
	}

	private void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] visited) {

		int temp = 0;
		visited[v] = true;
		Iterator<Integer> i = adj[v].iterator();

		while (i.hasNext()) {

			temp = i.next();
			if (!visited[temp]) {
				topologicalSortUtil(temp, stack, visited);
			}

		}

		System.out.println("before "+v);
		//adding new Integer is important otherwise solutions doesn't work. why?
		stack.push(new Integer(v));

	}

	public static void main(String[] args) {

		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.topologicalSort();
	}

}
