package com.example.sort;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] array1 = { 2, 3, 7, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] array2 = { 1, 8, 9, 11 };
		merge(array1, 4, array2, 4);
		System.out.println("Sorted Array " + Arrays.toString(array1));
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		while (m > 0 && n > 0) {

			if (nums1[m - 1] <= nums2[n - 1]) {
				nums1[m + n - 1] = nums2[n - 1];
				n--;
			} else {
				nums1[m + n - 1] = nums1[m - 1];
				m--;
			}
		}

		while (n > 0) {
			nums1[m + n - 1] = nums2[n - 1];
			n--;
		}

	}

}
