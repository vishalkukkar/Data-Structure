package com.example.arrayy;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		
		int[] nums1 = {1,2,5,11,15};
		int[] nums2 = {3,4,13,17,18};
		
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return findMedian(nums1,0,nums1.length - 1,nums2,0,nums2.length - 1);
	}

	private double findMedian(int[] nums1, int start_a, int end_a, int[] nums2, int start_b, int end_b) {
		
		if((end_a - start_a) == 1 && (end_b - start_b) == 1){
			return (Math.max(nums1[start_a],nums2[start_b]) + Math.min(nums1[end_a], nums2[end_b])) / 2;
		}
		
		
		int m1_index = (start_a + end_a) / 2;
		int m2_index = (start_b + end_b)/2;
		
		int m1 = nums1[m1_index];
		int m2 = nums2[m2_index];
		
		if(m1 == m2)
			return m1;
		else if(m1 < m2){
			start_a = m1_index;
			end_b = m2_index;
		}else{
			start_b = m2_index;
			end_a = m1_index;
		}
		
		return findMedian(nums1, start_a, end_a, nums2, start_b, end_b);
	}

}
