package com.example.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] array = { 2, 4, 2, 6, 7, 11, 10, 5 };
		mergeSort(array);
		System.out.println("Sorted Array " + Arrays.toString(array));
		
		
		System.out.println("abcd".substring(0,2));
	}

	private static void mergeSort(int[] array) {

		int n = array.length;

		if (n < 2)
			return;

		int mid = n / 2;

		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}

		for (int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];

		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right,array);
	}

	private static void merge(int[] left, int[] right, int[] array) {

		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {

			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else if (right[j] < left[i]) {
				array[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			array[k] = right[j];
			k++;
			j++;
		}
	}

}
