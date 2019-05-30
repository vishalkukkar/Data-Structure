package com.example.array.matrix;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


/** 
 * 00 01 02
 * 10 11 12
 * 20 21 22
 * 
 * */

public class CutOffTreesForGolfEvent {

	
	int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
	public static void main(String[] args) {

	}

	public int cutOffTree(List<List<Integer>> forest) {
		
		if(forest == null || forest.size() == 0) return -1;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o2[2] - o1[1]);
		
		for (int i = 0; i < forest.size(); i++) 
			for (int j = 0; j < forest.get(0).size(); j++) 
				queue.add(new int[]{i,j,forest.get(i).get(j)});
		
		int[] start = new int[2];
		int sum = 0;
		
		while(!queue.isEmpty()){
			
			int[] tree = queue.remove();
			int step = bfs(tree,start,forest);
			
			if(step < 0) return -1;
			sum += step;
			
			start[0] = tree[0];
			start[1] = tree[1];
		}
		
		
		
		return sum;

	}

	private int bfs(int[] tree, int[] start, List<List<Integer>> forest) {
		
		
		int r = forest.size();
		int c = forest.get(0).size();
		
		boolean[][] visited = new boolean[r][c];
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		int step = 0;
		
		while(!queue.isEmpty()){
			
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				
				int[] curr = queue.remove();
				if(curr[0] == tree[0] && curr[1] == tree[1]) return step;
				
				for (int j = 0; j < dirs.length; j++) {
					
					int x = curr[0] + dirs[j][0];
					int y = curr[1] + dirs[j][1];
					
					if(x < 0 || x >= r || y < 0 || y >= c || visited[x][y] == true || forest.get(x).get(y) == 0) 
						continue;
					queue.add(new int[]{x,y});
					visited[x][y] = true;
				}
				
				
			}
			
			step++;
		}
		
		return -1;
	}

}
