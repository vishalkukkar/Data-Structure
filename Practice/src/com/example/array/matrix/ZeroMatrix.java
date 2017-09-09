package com.example.array.matrix;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] array1 = { { 1, 2, 3 }, { 3, 0, 5 }, { 7, 8, 9 } };
		int[][] array = { 	{ 1, 2, 3, 4 }, 
				{ 1, 2, 3, 4 }, 
				{ 1, 2, 3, 4 }, 
				{ 1, 2, 3, 4 } };
		zeroMatrix(array);
	}

	private static void zeroMatrix(int[][] a) {
		int x = 0, y = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.println();
			for (int j = 0; j < a.length; j++) {

				if (a[i][j] == 0) {
					x = i;
					y = j;
				}
				System.out.print(a[i][j] + "  ");
			}
		}

		//for row and column;
		for (int i = 0; i < a.length; i++) {
			a[x][i] = 0;
			a[i][y] = 0;
		}
	
		System.out.println("\n\n");
		for (int i = 0; i < a.length; i++) {
			System.out.println();
			for (int j = 0; j < a.length; j++) {

				System.out.print(a[i][j] + "  ");
			}
		}
	}

}
