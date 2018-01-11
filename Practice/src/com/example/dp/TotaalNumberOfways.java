package com.example.dp;

//https://leetcode.com/problems/unique-paths/description/
public class TotaalNumberOfways {

	public static void main(String[] args) {

		System.out.println(uniquePaths(3, 7));
	}

	public static int uniquePaths(int m, int n) {

		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					matrix[i][j] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
			}
		}

		return matrix[m - 1][n - 1];

	}

}
