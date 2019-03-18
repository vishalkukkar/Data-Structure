package com.example.arrayy;

public class SearchInSortedArray {

	public static class ArrayReader {

		int[] array;

		public ArrayReader(int[] array) {
			this.array = array;
		}

		public int get(int i) {

			if (i > 9)
				return Integer.MAX_VALUE;
			else
				return array[i];

		}
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ArrayReader reader = new ArrayReader(array);
		System.out.println(search(reader, 90));
	}

	public static int search(ArrayReader reader, int target) {

		
		
		int start = 0;
		int index = 1;
		int end = 1;
		while (true) {
			int ele = reader.get(index);
			if (ele == target) {
				return index;
			} else if (ele < target) {
				index *= 2;
				end = index;
			} else {
				break;
			}
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int ele = reader.get(mid);
			if (ele == target)
				return mid;
			else if (ele < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}

}
