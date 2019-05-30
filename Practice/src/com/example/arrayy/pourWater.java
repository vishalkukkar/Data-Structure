package com.example.arrayy;

import java.util.Arrays;

public class pourWater {

	public static void main(String[] args) {

		int[] heights = { 2, 1, 1, 2, 1, 2, 2 };// Output: [2,2,2,3,2,2,2]
		int[] heights1 = { 1, 2, 3, 4 };
		int[] heights2 = { 3, 1, 3 };
		int[] height3 = { 1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1 };

		System.out.println(Arrays.toString(new pourWater().pourWater(heights, 4, 3)));
		System.out.println(Arrays.toString(new pourWater().pourWater(heights1, 2, 2)));
		System.out.println(Arrays.toString(new pourWater().pourWater(heights2, 5, 1)));
		System.out.println(Arrays.toString(new pourWater().pourWater(height3, 10, 2)));

		// Output: [2,2,3,4,3,2,2,2,3,4,3,2,1]
		// Expected: [1,2,3,4,3,3,2,2,3,4,3,2,1]
	}

	public int[] pourWater(int[] heights, int V, int K) {

		if (heights == null || heights.length == 0)
			return heights;

		for (int i = 0; i < V; i++) {

			// check if fall on left
			int left = K - 1;
			int minIndex = K;
			while (left >= 0) {

				if (heights[left] > heights[minIndex]) {
					break;
				}

				if (heights[left] < heights[minIndex]) {
					minIndex = left;
				}
				left--;
			}

			// found left
			if (minIndex != K) {
				heights[minIndex] += 1;
				continue;
			}

			// check if fall on right
			int right = K + 1;
			while (right < heights.length) {

				if (heights[right] > heights[minIndex]) {
					break;
				}

				if (heights[right] < heights[minIndex]) {
					minIndex = right;
				}
				right++;
			}

			// found right
			heights[minIndex]++;

		}

		return heights;
	}

}
