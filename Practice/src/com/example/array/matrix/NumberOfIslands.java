package com.example.array.matrix;

public class NumberOfIslands {

	public int[] offset = { -1, 0, +1 };

	private boolean isNeightborExists(int[][] grid, int i, int j) {

		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			if (grid[i][j] == 1)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, };

		NumberOfIslands solution = new NumberOfIslands();

		System.out.println(solution.numIslands(matrix));
	}

	public int numIslands(int[][] grid) {

		if (grid == null)
			return 0;

		int count = 0;

		// create visited array of size grid
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		// iterate through each node

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if ((grid[i][j] == 1) && (!visited[i][j])) {
					count += 1;
					dfs(grid, i, j, visited);
				}
			}
		}

		return count;

	}

	private void dfs(int[][] grid, int i, int j, boolean[][] visited) {

		if (visited[i][j])
			return;

		int xOffset;
		int yOffset;

		visited[i][j] = true;

		for (int k = 0; k < offset.length; k++) {
			xOffset = offset[k];
			for (int l = 0; l < offset.length; l++) {
				yOffset = offset[l];

				if (xOffset == 0 && yOffset == 0)
					continue;

				if (isNeightborExists(grid, i + xOffset, j + yOffset)) {
					dfs(grid, i + xOffset, j + yOffset, visited);
				}
			}
		}

	}

}
