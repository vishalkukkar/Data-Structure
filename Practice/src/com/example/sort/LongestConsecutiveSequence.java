package com.example.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] num = { 1, 2, 0, 1 };
		int[] nums = { 100, 200, 4, 3, 1, 2 };
		// 0 1 1 2

		System.out.println(longestConsecutive(nums));
	}

	public static int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int val : nums)
			set.add(val);
		int max = 1;

		for (int i = 0; i < nums.length; i++) {
			int sum = 1;
			int val = nums[i];
			if (set.remove(nums[i])) {

				while (set.remove(val - 1)) val--;
				sum = sum + (nums[i] - val);
				
				val = nums[i];

				while (set.remove(val + 1))val++;
				sum = sum + (val - nums[i]);

				max = Math.max(sum, max);

			}
		}
		return max;
	}

	public static int longestConsecutive2(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int max = 1;
		int temp = Integer.MIN_VALUE;
		int i = 0;
		int j = 1;

		// 1 2 3 4 100 200
		while (j < nums.length) {

			if (nums[j] - nums[i] == 1) {
				max++;
				temp = Math.max(max, temp);

			} else {
				max = 1;
			}

			i++;
			j++;

		}
		return temp;

	}

}
