package com.example.sort;

public class searchInRotatedArray {

	public static void main(String[] args) {
		//binary search
//		int[] input = {1,2,3,4,5,6,7,8,9,10,11};
//		System.out.println(binarySearch(1,input));
		
		int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		System.out.println(searchElement(5));
	}

	private static int searchElement(int data) {

		return 0;
	}
	
	private static Boolean binarySearch(int data,int[] array) {
		
		int start = 0;
		int end = array.length - 1;
		
		while(start < end){
			
			int mid = (start + end) / 2;
			if(array[mid] == data){
				return true;
			}else if(data < array[mid]){
				end = mid - 1;
			}else if (data > array[mid]){
				start = mid + 1;
			}
		}
		return false;
	}

}
