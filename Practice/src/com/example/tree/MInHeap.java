package com.example.tree;

import java.util.Arrays;

public class MInHeap {

	
	int capacity = 10;
	int size;
	int[] array = new int[capacity];
	
	
	public int getParentIndex(int index){return (index - 2) / 2;}
	public int getLeftChildIndex(int index){return (index * 2) + 1;}
	public int getRightChildIndex(int index){return (index * 2) + 2;}
	
	public Boolean hasParent(int index){return getParentIndex(index) >=0;}
	public Boolean hasLeftChild(int index){return getLeftChildIndex(index) < size;}
	public Boolean hasRightChild(int index){return getRightChildIndex(index) < size;}
	
	public int parent(int index){return array[getParentIndex(index)];}
	public int leftChild(int index){return array[getLeftChildIndex(index)];}
	public int rightChild(int index){return array[getRightChildIndex(index)];}
	
	
	public void ensureCapacity(){
		if(size == capacity){
			Arrays.copyOf(array, capacity * 2);
			capacity = capacity * 2;
		}
	}
	
	public void swap(int parent, int i) {

		int t = array[parent];
		array[parent] = array[i];
		array[i] = t;
	}
	
	
	public void insert(int value){
		
		array[size] = value;
		size++;
		heapifyUp();
		
	}
	public void poll(){
		if(size == 0)
			throw new IllegalArgumentException();
		
		array[0] = array[size - 1];
		size--;
		heapifyDown();
	}
	
	
	public void heapifyDown() {
		
		int index = 0;
		
		int smallChildIndex = getLeftChildIndex(index);
		
		while(hasLeftChild(index)){
			
			if(hasRightChild(index) && rightChild(index) < leftChild(index)){
				smallChildIndex = getRightChildIndex(index);
			}
			
			if(array[index] < array[smallChildIndex])
				break;
			else
				swap(index,smallChildIndex);
			
			index = smallChildIndex;
			
		}
		
	}
	public void heapifyUp() {
		
		int index = size - 1;
		
		while(hasParent(index) && parent(index) > array[index]){
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
		
	}
	
	public static void main(String[] args) {

		
	}

}
