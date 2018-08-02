package com.example.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Run {

	public static class Graph {

		LinkedList<Integer> adj[];
		private int n;
		Graph(int n) {
			this.adj = new LinkedList[n];
			this.n = n;

			for (int i = 0; i < n; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int i, int j) {
			adj[i].add(j);
		}

		public void DFS(int v) {
			boolean[] visited = new boolean[n];
			DFSUtil(v,visited);
		}

		private void DFSUtil(int n, boolean[] visited) {
			
			visited[n] = true;
			System.out.println("n"+n);
			Iterator<Integer> list = adj[n].iterator();
			
			while(list.hasNext()){
				int next = list.next();
				
				if(!visited[next]){
					DFSUtil(next, visited);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Long i = 0L;
		Long j = Long.MAX_VALUE;
		Set<String> set = new HashSet<>();
		while(i <= j){
			String key = String.format("%x", i);
			 if(set.contains(key)){
				 System.out.println(key +" "+i);
			 }
			 System.out.println(i);
			 set.add(key);
			 i++;
		}
		
		System.out.println("done!");
	    
	}

}
