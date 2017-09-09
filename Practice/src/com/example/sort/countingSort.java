package com.example.sort;

import java.util.Arrays;

public class countingSort {

	public static void main(String[] args) {

		int[] array = { 2, 4, 2, 6, 7, 11, 10, 5 };
		mergeSort(array, 11);
	}

	private static void mergeSort(int[] array, int max) {

		int[] numsCount = new int[max + 1];

		for (int i : array) {
			numsCount[i]++;
		}

		int[] sortedArray = new int[array.length];
		int index = 0;
		for (int i = 0; i < numsCount.length; i++) {

			int count = numsCount[i];

			for (int j = 0; j < count; j++) {
				sortedArray[index] = i;
				index++;
			}
		}

		System.out.println(Arrays.toString(sortedArray));
	}

}
