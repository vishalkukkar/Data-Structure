package com.example.array.matrix;

import java.util.ArrayList;
import java.util.List;

import com.util.Util;

public class SpiralMatrix {
	
	
	/**
	 * 
	 * @param args
	 * 
	 * 
	 * 00 01 02
	 * 10 11 12
	 * 20 21 22
	 */
	public static void main(String[] args) {
		int[][] matrix = 
				  {{1,2,3},
				  {8,9,4},
				  {7,6,5}};
		
		System.out.println(Util.print(spiralOrder(matrix)));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> res = new ArrayList<>();
		if(matrix == null) return null;
		
		int left = 0;
		int right = matrix[0].length - 1;
		int top = 0;
		int bottom = matrix.length - 1;
		
		
		while(true){
		
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			
			top++;
			if(left > right || top > bottom) 
				break;
			
			for (int i = top; i <= bottom; i++) {
				   res.add(matrix[i][right]);
			}
			
			right--;
			if(left > right || top > bottom) 
				break;
			
			for (int i = right; i >= left; i--) {
				res.add(matrix[bottom][i]);
			}
			
			bottom--;
			if(left > right || top > bottom) 
				break;
			
			for (int i = bottom; i >= top; i--) {
				res.add(matrix[i][left]);
			}
			
			left++;
			
			if(left > right || top > bottom) 
				break;
			
		}

		return res;

	}
}
