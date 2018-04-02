package com.example.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//This class represents a directed graph using adjacency list
//representation
public class GraphDFS {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	GraphDFS(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}

	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {

		adj[v].add(w);

	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[]) {

		if (visited[v] == true)
			return;

		System.out.print(" "+v);
		
		Iterator<Integer> iterator = adj[v].iterator();
		if (iterator.hasNext()) {
			
			
			int next = iterator.next();
			System.out.println("next "+next);
			visited[next] = true;
			DFSUtil(next,visited);
			
		}

	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {

		boolean[] visited = new boolean[this.V];
		
		System.out.println(Arrays.toString(visited));
		DFSUtil(v, visited);

	}

	public static void main(String args[]) {
		GraphDFS g = new GraphDFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}
}
// T
