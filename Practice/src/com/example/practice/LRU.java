package com.example.practice;

public class LRU {

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		
		System.out.println(new LRU().maxArea(height));
	}

	public int maxArea(int[] height) {

		int maxArea = 0;
		if (height == null)
			return maxArea;

		int i = 0;
		int j = height.length - 1;
		int area = 0;
		while (i < j) {

			area = (j - i) * Math.min(height[i], height[j]);

			if (height[i] < height[j])
				i++;
			else
				j--;

			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}
}
