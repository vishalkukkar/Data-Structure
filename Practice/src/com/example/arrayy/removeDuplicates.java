package com.example.arrayy;

import java.util.Arrays;

public class removeDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 1, 2 };
		System.out.println(removeDuplicates(array));
	}

	public static int removeDuplicates(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return 1;

		int j = 0;
		int i = 1;
		while (i < nums.length) {

			if (nums[i] == nums[j]) {
				i++;
			} else {
				j++;
				nums[j] = nums[i];
				i++;
			}

		}
		return j + 1;

	}
}
