package com.example.arrayy;

public class ColorSort {

	// https://leetcode.com/problems/sort-colors/description/
	public static void main(String[] args) {

	}

	public static void sortColors(int[] nums) {
		int[] temp = new int[3];
		for (int i = 0; i < nums.length; i++)
			temp[nums[i]]++;
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			int count = temp[i];
			for (int j = 0; j < count; j++) {
				nums[index] = i;
				index++;
			}
		}

	}

}
