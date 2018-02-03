package com.example.array.matrix;

import java.util.Arrays;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 * A = [ [ 1, 0, 0], [-1, 0, 3] ]
 * 
 * B = [ [ 7, 0, 0 ], [ 0, 0, 0 ], [ 0, 0, 1 ] ]
 * 
 * 
 * | 1 0 0 | | 7 0 0 | | 7 0 0 | AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 | | 0 0
 * 1 |
 */

public class MutiplyMatrix {

	public static void main(String[] args) {
		int[][] A = { { 1, 0, 0 }, { -1, 0, 3 } };

		/**
		 * 00 01 02 10 11 12
		 */

		int[][] B = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

		/**
		 * 00 01 02 10 11 12 20 21 22
		 */

		System.out.println(Arrays.deepToString(multiply(A, B)));
	}

	public static int[][] multiply(int[][] A, int[][] B) {

		int[][] result = new int[A.length][B[0].length];

		int ARow = 0;
		int ACol = 0;

		int resRow = 0;
		int resCol = 0;

		for (int k = 0; k < A.length; k++) {

			ARow = k;
			for (int i = 0; i < B[0].length; i++) {
			//	System.out.println();
				int temp = 0;
				for (int j = 0; j < B.length; j++) {
//					System.out.println("A[" + ARow + "]  A[" + ACol + "]");
//					System.out.println("B[" + j + "]  B[" + i + "]");
					temp = temp + (A[ARow][ACol] * B[j][i]);
					ACol++;
				}

				
				//System.out.println("result[" + resRow + "]  result[" + resCol + "]");
				
				/**
				 * 00 01 02
				 * 10 11 12
				 */
				result[resRow][resCol] = temp;
				resCol++;
				System.out.println("temp " + temp);
				ACol = 0;

			}
			resCol = 0;
			resRow++;

		}

		return result;

	}
}
