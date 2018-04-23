package com.example.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {

	int V;
	LinkedList<Integer> adj[];

	public GraphDFS(int V) {
		this.V = V;
		adj = new LinkedList[V];

		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(int i, int j) {
		adj[i].add(j);

	}

	private void DFS(int v) {

		boolean[] visited = new boolean[V];

		DFSUtil(v, visited);
	}

	private void DFSUtil(int v, boolean[] visited) {

		visited[v] = true;
		System.out.println(" " + v);
		LinkedList<Integer> l = adj[v];

		Iterator<Integer> iterator = l.iterator();
		while (iterator.hasNext()) {
			int curr = iterator.next();

			if (!visited[curr])
				DFSUtil(curr, visited);
		}
	}

	public static void main(String args[]) {

		GraphDFS g = new GraphDFS(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2);
	}

}
