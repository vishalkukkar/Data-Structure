package com.example.tree;

public class MInHeap {

	int capacity = 10;
	int size = 0;
	int[] array = new int[size];
	
	
	public int getLeftChildIndex(int index){return (2 * index + 1);}
	public int getRightChildIndex(int index){return (2 * index + 2);}
	public int getParentIndex(int index){return ((index-1) / 2);}
	
	public Boolean hasParent(int index){return 0 <= getParentIndex(index);};
	public Boolean hasLeftChild(int index){return size >= getLeftChildIndex(index);};
	public Boolean hasRightChild(int index){return size >= getRightChildIndex(index);};

	public int getParent(int index) {return array[getParentIndex(index)];}
	public int getLeftChild(int index) {return array[getLeftChildIndex(index)];}
	public int getRightChild(int index) {return array[getRightChildIndex(index)];}
	
	public void swap(int parent, int i) {

		int t = array[parent];
		array[parent] = array[i];
		array[i] = t;
	}
	
	
	public void insert(int value){
		if(size == capacity)
			return;
		else{
			array[size] = value;
			size++;
			heapyfyUp(size - 1);
		}
	}
	
	public void pop(){
		
		//replace 0th element with last and heapify down
		if(size == 0)
			return;
		else{
			array[0] = array[size - 1];
			size--;
			heapifyDown();
		}
	}
	public void heapifyDown() {
		
		int index = 0;
		
		
		while(hasLeftChild(index)){
			
			int smallIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
				smallIndex = getRightChildIndex(index);
			}
			
			//replace small index
			
			if()
		}
		
	}
	public void heapyfyUp(int index) {

		while(hasParent(index) && getParent(index) < array[index]){
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}
	
	public static void main(String[] args) {

		
	}

}
