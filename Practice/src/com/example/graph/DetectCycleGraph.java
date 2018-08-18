package com.example.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleGraph {

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

	private boolean isCycle(DetectCycleGraph graph) {

		boolean[] visited = new boolean[this.V];
		boolean[] curRec = new boolean[this.V];
		System.out.println(V);
		for (int i = 0; i < this.V; i++) {
			System.out.println("i "+i);
			if(isCycleUtil(visited,curRec,i))
				return true;
		}
		
		return false;
	}

	private boolean isCycleUtil(boolean[] visited, boolean[] curRec, int i) {

		
		if(visited[i] == false){
			
			visited[i] = true;
			curRec[i] = true;
			
			List<Integer> neighbours = edges.get(i);
			for(Integer v : neighbours){
				
				if(!visited[v] && isCycleUtil(visited, curRec, v))
					return true;
				else if(curRec[v])
					return true;
			}
		}
		
		curRec[i] = false;
		
		return false;
	}

	public static void main(String[] args) {

		DetectCycleGraph graph = new DetectCycleGraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		System.out.println(graph.isCycle(graph));
	}

}
