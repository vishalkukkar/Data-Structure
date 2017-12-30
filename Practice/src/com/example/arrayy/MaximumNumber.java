package com.example.arrayy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumber {

	public static void main(String[] args) {
		int[] array = { 6, 90, 9, 8 };
		System.out.println(largestNumber(array));
	}

	private static class LargerNumberComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			String order1 = a + b;
			String order2 = b + a;
			int test = order2.compareTo(order1);
			return test;
		}
	}

	public static String largestNumber(int[] nums) {
		// Get input integers as strings.
		String[] asStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}

		// Sort strings according to custom comparator.
		Arrays.sort(asStrs, new LargerNumberComparator());

		System.out.println(Arrays.toString(asStrs));
		// If, after being sorted, the largest number is `0`, the entire number
		// is zero.
		if (asStrs[0].equals("0")) {
			return "0";
		}

		// Build largest number from sorted array.
		String largestNumberStr = new String();
		for (String numAsStr : asStrs) {
			largestNumberStr += numAsStr;
		}

		return largestNumberStr;
	}
}