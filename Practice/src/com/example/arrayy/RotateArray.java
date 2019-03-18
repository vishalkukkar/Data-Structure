package com.example.arrayy;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7};
		rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	public static void rotate(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (order > arr.length) {
			order = order % arr.length;
		}

		// length of first part
		int a = arr.length - order;
		System.out.println(a);

		System.out.println(Arrays.toString(arr));
		reverse(arr, 0, a - 1);
		System.out.println(Arrays.toString(arr));
		reverse(arr, a, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		reverse(arr, 0, arr.length - 1);

	}

	public static void reverse(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;

		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	


	


}
