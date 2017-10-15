package com.example.arrayy;

import java.util.Arrays;

public class minHeap {

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
	
	public void insert(int value){
		ensureCapacity();
		System.out.println("size "+size+"  capacity "+capacity+" "+array.length);
		array[size] = value;
		heapifyUp();
		size++;
	}
	
	
	public void ensureCapacity(){
		if(size == capacity){
			array = Arrays.copyOf(array, capacity * 2);
			capacity = capacity * 2;
		}
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
	
	public static void main(String[] args) {
		
		minHeap m = new minHeap();
		m.insert(10);
		m.insert(5);
		m.insert(4);
		m.insert(1);
		m.delete();
		m.display();
		
	}

}
