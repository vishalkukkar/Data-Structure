package com.example.arrayy;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,5,11,15};
		int[] nums2 = {3,4,13,17,18};
		
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		
		if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		
		
		int x = nums1.length;
		int y = nums2.length;
		
		int low = 0;
		int high = x;
		
		
		while(low <= high){
			
			int partitionX = (low + high) / 2;
			int patitionY = (x + y + 1) / 2 - partitionX;
			
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1] ;
			int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
			int maxLeftY = patitionY == 0 ? Integer.MIN_VALUE : nums2[patitionY - 1] ;
			int minRightY =  patitionY == y ? Integer.MAX_VALUE : nums2[patitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX){
				
				if((x + y) % 2 == 0){
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2; 
				}
				
				return Math.max(maxLeftY, maxLeftX);
			}else if(maxLeftX > minRightY){
				high = partitionX - 1;
			}else{
				low = partitionX + 1;
			}
				
			
		}
		
		return -1;
		
	}


}
