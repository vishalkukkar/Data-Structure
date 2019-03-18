package com.example.arrayy;

import java.util.Arrays;

public class FindDuplicates {

	public static void main(String[] args) {

		/*int arr[] = { 1, 2, 3, 1, 3, 123, 123 };
		printRepeating(arr, 7);
		System.out.println(Arrays.toString(arr));*/
		
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums));

	}

	// https://leetcode.com/problems/find-the-duplicate-number/description/
	public static int findDuplicate(int[] nums) {

		int slow = nums[0];
		int fast = nums[nums[0]];
		
		System.out.println(slow+" "+fast);
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			
			System.out.println(slow+" "+fast);
		}

		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

	public static void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {

			System.out.println(arr[i]);

			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

}
