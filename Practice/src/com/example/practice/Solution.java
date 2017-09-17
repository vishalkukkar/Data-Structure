package com.example.practice;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4};
		System.out.println(kSub(3,nums));
	}

	public static long kSub(int k, int[] nums) {
		
		int[] array = new int[k];
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			array[((sum % k) + k) % k]++;
		}
		int result = 0;
		for (int i = 0; i < k; i++)
			if (array[i] > 1)
				result += (array[i] * (array[i] - 1)) / 2;
		result += array[0];
		return result;
	}

}
