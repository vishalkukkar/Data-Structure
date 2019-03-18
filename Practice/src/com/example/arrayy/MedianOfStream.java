package com.example.arrayy;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianOfStream {

	
	// 1
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	//
	private void addNumber(int num) {
		
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		
		if(minHeap.size() > maxHeap.size()){
			maxHeap.add(minHeap.poll());
		}
		
	}

	private Double getMedian() {
		
		if(minHeap.size() > maxHeap.size())
			 return minHeap.peek().doubleValue();
		else{
			return ((minHeap.peek().doubleValue()  + maxHeap.peek().doubleValue()) / 2);
		}
	}

	public static void main(String[] args) {

		MedianOfStream stream = new MedianOfStream();

		stream.addNumber(1);
		System.out.println(stream.getMedian());
		
		stream.addNumber(2);
		System.out.println(stream.getMedian());
		
		stream.addNumber(3);
		System.out.println(stream.getMedian());
		
		stream.addNumber(4);
		System.out.println(stream.getMedian());
		
		stream.addNumber(5);
		System.out.println(stream.getMedian());
	}

}
