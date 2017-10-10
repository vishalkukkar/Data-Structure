package com.example.arrayy;

import java.util.Arrays;

public class removeDuplicatesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 1, 1, 2, 2, 2, 3 };
		System.out.println(removeDuplicates(array));
	}

	public static int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return 1;

		int prev = 1;
		int curr = 2;

		while (curr < nums.length) {
			if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1])
				curr++;
			else {
				prev++;
				nums[prev] = nums[curr];
				curr++;
			}
		}
		return prev + 1;

	}
}
