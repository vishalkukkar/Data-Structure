package com.example.arrayy;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianOfStream {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	
	private void addNumber(int num) {

		maxHeap.offer(num);
		minHeap.offer(maxHeap.remove());
		
		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.remove());
		}
	}

	private Double getMedian() {

		if(maxHeap.size() == minHeap.size())
			return Double.valueOf((Double.valueOf(maxHeap.peek() + minHeap.peek())) / 2);
		
		return Double.valueOf(maxHeap.peek());
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
