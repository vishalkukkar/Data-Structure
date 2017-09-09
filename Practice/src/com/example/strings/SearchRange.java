package com.example.strings;

/*
 * 
 * 	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
 */
public class SearchRange {

	public static void main(String[] args) {

		int[] input = { 5, 7, 7, 8, 8, 10 };
		int[] result = searchRange(input, 8);
		for (int i = 0; i < result.length; i++) {
			System.out.println("  " + result[i]);
		}
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		if (nums == null || nums.length == 0)
			return result;

		int start = 0;
		int end = nums.length - 1;

		int i = 0;
		while (start < end) {

			int mid = (start + end) / 2;

			if (nums[mid] == target) {
				result[i] = mid;
				nums[mid] = target - 1;
				start = 0;
				end = nums.length;
				i++;

				if (i == 2) {
					int temp = result[0];
					result[0] = result[1];
					result[1] = temp;

					return result;
				}
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return result;

	}

}
