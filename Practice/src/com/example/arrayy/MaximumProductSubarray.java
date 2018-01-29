package com.example.arrayy;

public class MaximumProductSubarray {

	public static void main(String[] args) {

		int[] array = { 2, 3, -2, 4 };

		System.out.println(maxProduct(array));

	}

	public static int maxProduct(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		int min = nums[0];
		int max = nums[0];
		int result = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]),nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			result = Math.max(max, result);
		}
		return result;

	}

}
