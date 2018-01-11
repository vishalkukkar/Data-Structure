package com.example.sort;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int[] array = { 15, 20, 40, 85, 20, 35, 80, 95, 30, 55, 95, 105, 40, 80, 100, 120 };

		int[][] matrix = new int[4][4];
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = array[count];
				count++;
			}
		}

		// print matrix
		/*
		 * for (int i = 0; i < 4; i++) { System.out.println(); for (int j = 0; j
		 * < 4; j++) { System.out.print(matrix[i][j]+" "); } }
		 */

		System.out.println(searchMatrix(55, matrix));
	}

	private static Boolean searchMatrix(int val, int[][] matrix) {

		int row = 0;
		int col = matrix[0].length - 1;

		while (row <= 3 && col >= 0) {

			if (matrix[row][col] == val)
				return true;
			else if (matrix[row][col] > val)
				col--;
			else
				row++;
		}

		return false;
	}

}
