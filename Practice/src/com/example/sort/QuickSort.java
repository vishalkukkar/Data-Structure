package com.example.sort;

import java.util.Arrays;

public class QuickSort {

	private static int[] array = { 7,2, 4, 2, 6, 7, 11, 10, 5 ,5, 5,7,7,7,7,7};

	public static void main(String[] args) {

		quickSort(array, 0, array.length - 1,7);
		System.out.println("Sorted Array " + Arrays.toString(array));
	}

	private static void quickSort(int[] array, int start, int end,int num) {

		if (start < end) {
			int pIndex = partition(array, start, end,num);
			quickSort(array, start, pIndex - 1,num);
			quickSort(array, pIndex + 1, end,num);
		}

	}

	private static int partition(int[] array, int start, int end,int num) {

		int pIndex = start;
		int pivot = array[end];
		
		for (int i = start; i < end; i++) {
			
			
			if(pivot == num)
				continue;
			
			if (array[i] == num || array[i] <= pivot) {

				int temp = array[pIndex];
				array[pIndex] = array[i];
				array[i] = temp;

				pIndex = pIndex + 1;
			}
		}

		int temp = array[end];
		array[end] = array[pIndex];
		array[pIndex] = temp;
		
		return pIndex;
	}
}
