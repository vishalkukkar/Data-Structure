package com.example.array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] array1 = { { 1, 2, 3 }, { 3, 0, 5 }, { 7, 8, 9 } };
		int[][] array = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		zeroMatrix(array1);
	}

	private static void zeroMatrix(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		System.out.println("\n\n");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}
