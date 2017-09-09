package com.example.array.matrix;

import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {

		int[][] array = { 	{ 1, 2, 3, 4 }, 
							{ 1, 2, 3, 4 }, 
							{ 1, 2, 3, 4 }, 
							{ 1, 2, 3, 4 } };
		int[][] array1 = { { 1, 2, 3 }, 
						   { 3, 4, 5 }, 
						   { 7, 8, 9 } };
		
		
		
		System.out.println(Arrays.deepToString(array));
		rotateMatrix(array);

	}

	private static void rotateMatrix(int[][] a) {

		int len = a.length - 1;
		System.out.println(len);
		for (int i = 0; i < a.length / 2; i++) {
			for (int j = i; j < len - i; j++) {

				int temp = a[i][j];
				a[i][j] = a[len - j][i];
				a[len - j][i] = a[len - i] [len - j];
				a[len - i][len - j] = a[j][len - i];
				a[j][len - i] = temp;

			}
		}

		System.out.println(Arrays.deepToString(a));
	}

}
