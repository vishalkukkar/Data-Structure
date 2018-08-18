package com.example.arrayy;

public class FindMedianOfSortedArray {

	public static void main(String[] args) {

		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 18, 21, 25 };

		//1 3 7 8 9 11 15 18 19 21 25
		FindMedianOfSortedArray mm = new FindMedianOfSortedArray();
		System.out.println(mm.findMedianSortedArrays(x, y));
	}

	public double findMedianSortedArrays(int nums1[], int nums2[]) {
		
		if(nums1 == null || nums2 == null) return -1.0;
		
		if(nums1.length > nums2.length)
			return (findMedianSortedArrays(nums2, nums1));
		
		int x = nums1.length;
		int y = nums2.length;
		
		
		int low = 0;
		int high = x;
		
		while(low <= high){
			
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1)/ 2 - partitionX;
			
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
			
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
			
			if((maxLeftX <= minRightY) && (maxLeftY <= minRightX)){
				
				if((x + y) % 2 == 0){
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX)) / 2;
				}
				return (double) Math.max(maxLeftX, maxLeftY);
			}else if(maxLeftX > minRightY){
				high = partitionX - 1;
			}else{
				low = partitionX + 1;
			}
			
		}
		throw new IllegalArgumentException();
	}

}
