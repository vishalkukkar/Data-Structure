package com.example.array.matrix;

import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 3 }, { 3, 4, 5 }, { 7, 8, 9 } };
		int[][] array1 = { { 1, 2, 3 }, { 3, 4, 5 }, { 7, 8, 9 } };

		rotate(array1);
		rotateImage(array);
		System.out.println(Arrays.deepToString(array1));
		System.out.println(Arrays.deepToString(array));
		
		

	}
	
	public void rotate1(int[][] matrix) {
		
		int n = matrix.length;
		
		for (int i = 0; i <n / 2; i++) {
			for (int j = i; j < n - i -1; j++) {
				
				int t = matrix[i][j];
				 matrix[i][j] = matrix[n - j - 1][i];
				 matrix[n - j - 1][i] =  matrix[n - i -1][n - j - 1];
				 matrix[n - i -1][n - j - 1]  =  matrix[j][n - i -1];
				 matrix[j][n - i -1] = t;
			}
			
		}
		return;
		
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int layer = n / 2;

		for (int i = 0; i < layer; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}
	
	public static void rotateImage(int[][] matrix){
		int n = matrix.length;
		int layer = n / 2;
		
		for (int i = 0; i < layer; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				
				matrix[j][n - i - 1] = tmp;
				
			}
		}
		
	}
}
