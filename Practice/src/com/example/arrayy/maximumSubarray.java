package com.example.arrayy;

public class maximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(getMaxSubarray(array));
	}

	private static int getMaxSubarray(int[] array) {
		
		int max = array[0];
		int newMax = array[0];
		
		
		for (int i = 0; i < array.length; i++) {
			newMax = Math.max(array[i] + newMax, array[i]);
			max = Math.max(newMax, max);
		}
		
		return max;
	}

}
