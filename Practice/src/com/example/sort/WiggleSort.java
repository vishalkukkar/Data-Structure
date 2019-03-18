package com.example.sort;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {

		int[] nums = { 3, 5, 2, 1, 6, 4 };
		// Output: One possible answer is [3,5,1,6,2,4]
		
		new WiggleSort().wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void wiggleSort(int[] nums) {

		if(nums == null || nums.length == 0) return ;
		
		Arrays.sort(nums);
		
		if(nums.length > 2){
			int i = 1;
			int j = 2;
			
			while(j < nums.length){
				int t = nums[i];
				nums[i] = nums[j];
				nums[j] = t;
				
				i += 2;
				j += 2;
			}
		}
		
		
		for (int i = 0; i < 9; i++) {
			boolean[] array = new boolean[9];
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for (int k = i % 3 * 3; k < i % 3 * 3 + 3; k++) {
					int c = board[i][j] - '1';
					
					if(array[c])
						return false;
					else
						array[c] = true;
					
				}
				}
			}
		}
	}

}
