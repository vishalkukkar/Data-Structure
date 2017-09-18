package com.example.arrayy;

class Solution {

	public int[] productExceptSelf1(int[] nums) {

		int[] t1 = new int[nums.length];
		int[] t2 = new int[nums.length];

		t1[0] = 1;
		t2[nums.length - 1] = 1;

		for (int i = 0; i < nums.length - 1; i++) {
			t1[i + 1] = t1[i] * nums[i];
		}

		for (int i = nums.length - 1; i > 0; i--) {
			t2[i - 1] = t2[i] * nums[i];
		}

		for (int i = 0; i < t2.length; i++) {
			nums[i] = t1[i] * t2[i];
		}
		return nums;

	}
}
