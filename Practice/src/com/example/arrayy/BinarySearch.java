package com.example.arrayy;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 1, 2, 3, 4, 5, 6 };

		System.out.println(search(a, 2));
	}
	
	static int search(int[] a, int value) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {

			int mid = (end + start) / 2;
			if (a[mid] == value)
				return a[mid];
			else if (value <= a[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return 0;

	}

}
