package com.example.array.matrix;

public class LongestIncreasingPath {

	public static void main(String[] args) {

		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(matrix));

	}

	int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int longestIncreasingPath(int[][] matrix) {

		int[][] cache = new int[matrix.length][matrix[0].length];
		int max = 1;

		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {

				max = Math.max(CalculateSequence(matrix, i, j, cache), max);
			}
		}
		return max;
	}

	private int CalculateSequence(int[][] matrix, int i, int j, int[][] cache) {

		if (cache[i][j] != 0) return cache[i][j];
		int max = 1;
		for (int[] d : dir) {

			int x = i + d[0];
			int y = j + d[1];

			if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
				continue;

			int len = 1 + CalculateSequence(matrix, x, y, cache);
			max = Math.max(max, len);
		}

		cache[i][j] = max;
		return max;
	}

}
