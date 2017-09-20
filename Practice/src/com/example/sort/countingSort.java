package com.example.sort;

import java.util.Arrays;

public class countingSort {

	public static void main(String[] args) {

		int[] array = { 2, 4, 2, 5, 2, 5 };
		countSort(array, 5);
	}

	private static void countSort(int[] array, int max) {

		int[] temp = new int[max + 1];
		int[] res = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			temp[array[i]]++;
		}
		
		System.out.println(Arrays.toString(temp));
		int index = 0;
		for (int i = 0; i < temp.length; i++) {

			int count = temp[i];

			for (int j = 0; j < count; j++) {
				res[index] = i;
				index++;
			}
		}

		System.out.println(Arrays.toString(res));
	}

}
