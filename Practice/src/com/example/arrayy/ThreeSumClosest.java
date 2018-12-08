package com.example.arrayy;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {

		int[] nums = { 13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1,
				-15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9,
				0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10,
				1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7,
				0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6 };
		int target = -59;

		System.out.println(threeSumClosest(nums, target));

	}

	public static int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int i = 0, j = 0, k = 0;
		int sum = 0;
		int closest = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;

		for (i = 0; i < nums.length; i++) {

			j = i + 1;
			k = nums.length - 1;

			while (j < k) {

				sum = nums[i] + nums[j] + nums[k];
				int dist = getDistance(sum, target);

				if (sum == target) {
					return target;
				} else {
					if (sum < target) {
						j++;
					} else {
						k--;
					}
					
					if (nums[j] + nums[k] == sum) return target;
					System.out.println("sum "+sum+" dist "+dist+ " closest "+closest );
					if (dist < closest) {
						closest = dist;
						minSum = sum;
					}
				}
			}
		}

		return minSum;
	}

	private static int getDistance(int m, int n) {

		if (m < 0 || n < 0) {
			return Math.abs(m) + Math.abs(n);
		} else
			return Math.abs(m - n);
	}

}
