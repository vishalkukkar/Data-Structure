package com.example.arrayy;

import java.util.Arrays;

/*
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElement {

	public static void main(String[] args) {

		int[] array = { 2,1};
		System.out.println(findKthLargest(array, 1));

	}
	
	public static class minHeap {

		
		int capacity = 2;
		int size = 0;
		int[] array = new int[capacity];
				
		public int getLeftChildIndex(int index) {return index * 2 + 1;}
		public int getRightChildIndex(int index) {return index * 2 + 2;}
		public int getParentIndex(int index) {return index - 2 / 2;}
		
		public boolean hasLeftChild(int index){return getLeftChildIndex(index) <= size; }
		public boolean hasRightChild(int index){return getRightChildIndex(index) <= size; }
		public boolean hasParent(int index){return getParentIndex(index) >= 0; }
		
		public int getLeftChild(int index){return array[getLeftChildIndex(index)];}
		public int getRightChild(int index){return array[getRightChildIndex(index)];}
		public int getParent(int index){return array[getParentIndex(index)];}
		
		public int[] getArray(){
			return array;
		}
		public void insert(int value){
			ensureCapacity();
			array[size] = value;
			heapifyUp();
			size++;
		}
		
		public void heapifyUp() {
			int index = size;
			
			while(hasParent(index) && getParent(index) > array[index]){
				
				//swap
				int temp = getParent(index);
				array[getParentIndex(index)] = array[index];
				array[index] = temp;
				
				//update cureent index
				index = getParentIndex(index);
			}
		}
		
		private void delete() {
			
			if(size == 0)
				return;
			
			array[0] = array[size - 1];
			size--;
			heapifyDown();
			
		}
		
		public void ensureCapacity(){
			if(size == capacity){
				array = Arrays.copyOf(array, capacity * 2);
				capacity = capacity * 2;
			}
		}
		
		private void heapifyDown() {
			
			int index = 0;
			int smallChildIndex = 0;
			while(hasLeftChild(index)){
				 smallChildIndex = getLeftChildIndex(index);
				 
				 if(hasRightChild(index) && getLeftChild(index) > getRightChild(index)){
					 smallChildIndex = getRightChildIndex(index);
				 }
				 
				 if(array[index] < array[smallChildIndex])
					 break;
				 else{
					 int temp = array[index];
					 array[index] = array[smallChildIndex];
					 array[smallChildIndex] = temp;
				 }
				 index = smallChildIndex;
			}
		}
		public void display(){
			for (int i = 0; i < size; i++) {
				System.out.println(array[i]);
			}
		}

	}

	public static int findKthLargest(int[] nums, int k) {
		
		
		if(nums == null || nums.length == 0)
			return 0;
		
		if(k > nums.length)
			return 0;
		
		minHeap m = new minHeap();
		for (int i = 0; i < nums.length; i++) {
			m.insert(nums[i]);
		}
		k = nums.length - k;
		int[] a = m.getArray();
		return a[k];
		
	}

}
