package com.example.java;

public class TrappingRainWater {

	public static void main(String[] args) {

		int[] input = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		
		System.out.println(trap(input));
	}

	public static int trap(int[] height) {

		int maxTillNow = 0;
		int maxWater = 0;

		int maxHeightOnLeft = 0;
		int[] maxHeightFromRight = new int[height.length];

		for (int i = height.length - 1; i > 0; i--) {

			if (height[i] > maxTillNow) {
				maxTillNow = height[i];
				maxHeightFromRight[i] = maxTillNow;
			} else {
				maxHeightFromRight[i] = maxTillNow;
			}
		}

		for (int i = 0; i < height.length; i++) {

			maxWater = maxWater + Math.max(Math.min(maxHeightFromRight[i], maxHeightOnLeft) - height[i], 0);
			if (height[i] > maxHeightOnLeft)
				maxHeightOnLeft = height[i];
		}
		return maxWater;
	}

}
