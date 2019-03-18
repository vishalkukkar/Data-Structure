package com.example.array.matrix;

import com.util.Util;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] array1 = { { 1, 2, 3 }, { 3, 0, 5 }, { 7, 8, 9 } };
		int[][] array = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		zeroMatrix(array1);
		System.out.println(Util.print(array1));
		
		int[][] array2 = { { 1, 2, 3 }, { 3, 0, 5 }, { 7, 8, 9 } };
		setZeroes(array2);
		System.out.println(Util.print(array2));
	}
	
	/***
	 * 
	 * 00 01 02
	 * 10 11 12
	 * 20 21 22
	 */

	public static void setZeroes(int[][] matrix) {
        
		boolean isCol = false;
        if(matrix == null || matrix.length == 0)
        	return;
        
     
        for (int i = 0; i < matrix.length; i++) {
        	
        	   if(matrix[i][0] == 0)
               	isCol = true;
        	   
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
        
        //set rows to zero 
        for (int i = 1; i < matrix.length; i++) {
        	 for (int j = 1; j < matrix[0].length; j++) {
        		 if(matrix[i][0] == 0 || matrix[0][j] == 0)
        				 	matrix[i][j] = 0;
        	 }
        		
		}
        
        // set colums
       
        if(matrix[0][0] == 0){
        	 for (int i = 0; i < matrix[0].length; i++) {
        		 matrix[0][i] = 0;
        	 }
       	}
        
        if(isCol){
        	for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
        }
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
