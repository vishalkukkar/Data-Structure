package com.example.dp;

public class LongestIncresingSubSequence {

	public static void main(String[] args) {

		int[] array = { 3, 4, -1, 0, 6, 2, 3 };
		System.out.println(getSubSequence(array));
	}

	private static int getSubSequence(int[] nums) {

		int[] t = new int[nums.length];

		for (int i = 0; i < t.length; i++) {
			t[i] = 1;
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (t[j] + 1 > t[i])
						t[i] = t[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < t.length; i++) {
			if (t[i] > max)
				max = t[i];
		}

		return max;
	}

}
