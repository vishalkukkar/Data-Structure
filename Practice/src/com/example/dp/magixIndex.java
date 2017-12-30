package com.example.dp;

public class magixIndex {

	public static void main(String[] args) {

		int[] array = { -10,-5,-2,-1,2,5,6};
		System.out.println(getMagicIndex(array, 0, array.length - 1));
	}

	private static int getMagicIndex(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
			int mid = (start + end) / 2;
			
			if(array[mid] == mid)
				return mid;
			else if(array[mid] > mid)
				return getMagicIndex(array, start, mid - 1);
			else
				return getMagicIndex(array, mid + 1,end);
	}

}
