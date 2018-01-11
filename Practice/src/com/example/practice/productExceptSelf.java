package com.example.practice;

import java.util.Arrays;

public class productExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {

		int[] t1 = new int[nums.length];
		int[] t2 = new int[nums.length];

		t1[0] = 1;
		t2[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			t1[i] = nums[i] * t1[i - 1];
		}

		System.out.println(Arrays.toString(t1));
		for (int i = nums.length - 2; i >= 0; i--) {
			t2[i] = nums[i] * t2[i + 1];
		}

		for (int i = 0; i < t2.length; i++) {
			nums[i] = t1[i] * t2[i];
		}

		return nums;

	}
}
