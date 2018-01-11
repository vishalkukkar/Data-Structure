package com.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] array = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(array));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return list;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			int j = i + 1;
			int k = nums.length - 1;

			if(i!= 0 && nums[i] == nums[i-1]){
				continue;
			}
			
			while (j < k) {

				if (nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> sub = new ArrayList<>();
					sub.add(nums[i]);
					sub.add(nums[j]);
					sub.add(nums[k]);
					list.add(sub);
					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;

				} else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else {
					j++;
				}
			}
		}

		return list;

	}
}
