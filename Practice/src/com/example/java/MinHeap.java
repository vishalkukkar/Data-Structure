package com.example.java;

import java.util.Arrays;

public class MinHeap {

	int size = 0;
	int capacity;

	int[] array = null;

	MinHeap(int capacity) {
		array = new int[capacity];
		this.capacity = capacity;
	}

	public int getParentIndex(int index) {
		return index / 2;
	}

	public int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}

	public int getRightChildIndex(int index) {
		return index * 2 + 2;
	}

	public Boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public Boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) <= size;
	}

	public Boolean hasRightChild(int index) {
		return getRightChildIndex(index) <= size;
	}

	public int getParent(int index) {
		return array[getParentIndex(index)];
	}

	public int getLeftChild(int index) {
		return array[getLeftChildIndex(index)];
	}

	public int getRightChild(int index) {
		return array[getRightChildIndex(index)];
	}

	private void insert(int element) {
		ensureCapacity(size);
		array[size] = element;
		size++;
		heapifyUp();

		System.out.println(Arrays.toString(array));
	}

	private void heapifyUp() {
		int index = size - 1;

		while (hasParent(index)) {

			int ele = getParent(index);
			if (array[index] < ele) {
				int temp = array[index];
				array[index] = array[getParentIndex(index)];
				array[getParentIndex(index)] = temp;
			} else {
				break;
			}

			index = getParentIndex(index);
		}
	}

	private void remove() {

		if (size != 0) {
			System.out.println(size);
			array[0] = array[size - 1];
			array[size - 1] = 0;
			size--;
			heapifyDown();
		}
	}

	private void heapifyDown() {

		int index = 0;
		int smallIndex = 0;
		while (hasLeftChild(index) ) {
			// get smaller child for min heap
			
				
			smallIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && getRightChild(index) < getLeftChild(index) 
					&& smallIndex != size ) {
				smallIndex = getRightChildIndex(index);
			}
			
			System.out.println("small "+smallIndex+" size "+(size));

			// swap if found smaller element in any child
			if (array[smallIndex] < array[index]) {
				int temp = array[smallIndex];
				array[smallIndex] = array[index];
				array[index] = temp;

			} else
				break;
			
			index = smallIndex;
			
		}
		
		System.out.println("-->Remove "+Arrays.toString(array));
	}

	private void ensureCapacity(int size) {

		if (size == capacity) {
			array = Arrays.copyOf(array, capacity * 2);
			capacity = capacity * 2;
		}

	}

	public static void main(String[] args) {

		MinHeap heap = new MinHeap(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(20);
		heap.insert(17);
		heap.insert(25);

		heap.remove();
	}

}
