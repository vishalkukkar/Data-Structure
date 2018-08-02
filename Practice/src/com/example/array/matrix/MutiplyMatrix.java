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
		int[][] B = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

		System.out.println(Arrays.deepToString(multiply(A, B)));
	}

	public static int[][] multiply(int[][] A, int[][] B) {

		int[][] result = new int[A.length][B[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] != 0)
					for (int k = 0; k < result[0].length; k++) {
						result[i][j] = result[i][j] + (A[i][j] * B[j][k]) ;
					}
			}
		}
		return result;
	}

}
