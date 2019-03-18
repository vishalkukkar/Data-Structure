package com.example.array.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.util.Util;

public class NumberOfIslands {

	public int[] offset = { -1, 0, +1 };

	public static void main(String[] args) {

		char[][] matrix = { { '1', '1', '1', '1', '0' ,'1','1','1','1', '0', '1','1','1'},
							};

		NumberOfIslands solution = new NumberOfIslands();

		System.out.println("soln "+solution.numIslandsBFS(matrix));
		//System.out.println("soln 2"+solution.numIslands(matrix));
	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, 1, -1, 0 };

	public int numIslandsBFS(char[][] grid) {

		if (grid == null)
			return 0;

		int count = 0;
		Set<Value> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				Value v = new Value(i, j);
				if ((grid[i][j] == '1') && !set.contains(v)) {
					count += 1;
					bfs(grid, i, j, set);
				}
			}
		}
		
		return count;

	}

	private static void bfs(char[][] grid, int i, int j, Set<Value> set) {

		Queue<Value> queue = new LinkedList<Value>();
		Value code = new Value(i, j);
		queue.add(code);

		while (!queue.isEmpty()) {
			Value curr = queue.remove();

			if (set.contains(curr))
				continue;
			set.add(curr);

			for (int k = 0; k < dx.length; k++) {

				int m = curr.getX() + dx[k];
				int n = curr.getY() + dy[k];
				
				if (isValid(m, n, grid)) {
					queue.add(new Value(m, n));
				}
			}

		}

	}
	
	public static class Value{
		
		private int x;
		private int y;
		
		public Value(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Value other = (Value) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
		
	}

	private static boolean isValid(int i, int j, char[][] grid) {

		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
			return true;
		}
		return false;
	}

	public int numIslands(char[][] grid) {

		if (grid == null)
			return 0;

		int count = 0;

		// create visited array of size grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if ((grid[i][j] == '1')) {
					count += 1;
					dfs(grid, i, j);
				}
			}
		}

		return count;

	}

	private void dfs(char[][] grid, int i, int j) {

		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {

			if (grid[i][j] == '1') {
				grid[i][j] = '0';

				dfs(grid, i + 1, j);
				dfs(grid, i - 1, j);
				dfs(grid, i, j + 1);
				dfs(grid, i, j - 1);
			}

		}
	}

}
