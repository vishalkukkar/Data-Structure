package com.example.strings;

import com.util.Util;

public class EditDistance {

	public static void main(String[] args) {

		System.out.println(minDistance("horse", "hor"));

	}

	public static int minDistance(String word1, String word2) {

		int[][] matrix = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i < matrix[0].length; i++)
			matrix[0][i] = i;

		for (int i = 0; i < matrix.length; i++)
			matrix[i][0] = i;
		
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
		}

		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {

				if (array1[i - 1] == array2[j - 1])
					matrix[i][j] = matrix[i - 1][j - 1];
				else
					matrix[i][j] = 1 + min(matrix[i - 1][j], matrix[i][j - 1], matrix[i - 1][j - 1]);
			}
		}

		return matrix[word1.length()][word2.length()];
	}

	public static int min(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}
