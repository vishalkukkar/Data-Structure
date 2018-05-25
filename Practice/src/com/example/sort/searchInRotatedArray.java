package com.example.sort;

public class searchInRotatedArray {

	public static void main(String[] args) {
		// binary search
		// int[] input = {1,2,3,4,5,6,7,8,9,10,11};
		// System.out.println(binarySearch(1,input));

		int[] array = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(array,0));
	}

	public static int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return 0;

		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {

			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[start] <= nums[mid]) {

				if (nums[start] <= target && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else {

				if (nums[mid] < target && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}

		}

		return -1;

	}

	private static Boolean binarySearch(int data, int[] array) {

		int start = 0;
		int end = array.length - 1;

		while (start < end) {

			int mid = (start + end) / 2;
			if (array[mid] == data) {
				return true;
			} else if (data < array[mid]) {
				end = mid - 1;
			} else if (data > array[mid]) {
				start = mid + 1;
			}
		}
		return false;
	}

}
