package com.example.arrayy;

import java.util.Arrays;

public class SingleNumberII {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 2, 3, 3, 3, 5, 5, 5, 6 };
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);
		if (nums[0] != nums[1])
			return nums[0];

		for (int i = 2; i < nums.length; i++) {

			if (nums[i] != nums[i - 1] && nums[i - 1] != nums[i - 2]) {
				return nums[i - 1];
			}
			
			if(i == nums.length - 1 && nums[i] != nums[i - 1])
				return nums[i];
		}
		return 0;

	}
}
