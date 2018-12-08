package com.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MergeInterval{

	public static class Range {
		int start;
		int end;

		Range() {
			start = 0;
			end = 0;
		}

		Range(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Range [start=" + start + ", end=" + end + "]";
		}

	}

	/***
	 * 
	 * @param args
	 *            Apple Coderpad sample example:
	 *
	 *            Input : 1-10,14-35,3-3,9-25
	 * 
	 *            Output : 1-35
	 * 
	 * 
	 *            Input : 1-10, 11-20 25-30
	 * 
	 *            Output : 1-20, 25-30
	 * 
	 *            Note: For second example I think ans should be same as input
	 *            as there is difference of 1 in 1 - 10 and 11 - 20 so we
	 *            shouldn't merge that Range but I implemented that case too
	 *            for expected output mentioned
	 */
	public static void main(String[] args) {

		
		Range range5 = new Range(8, 10);
		Range range6 = new Range(4, 9);
		Range range7 = new Range(4, 17);
		
		
		Range[] array = new Range[3];
		array[0] = range5;
		array[1] = range6;
		array[2] = range7;
		
		System.out.println(new MergeInterval().merge(array));
	}

	public int merge(Range[] list) {
		
		if (list == null || list.length == 0)
			return 0;
		

		int[] start= new int[list.length];
		int[] end = new int[list.length];
		
		int i = 0;
		
		for(Range r : list){
			
			start[i] = r.start;
			end[i] = r.end;
			i++;
		}

		Arrays.sort(start);
		Arrays.sort(end);
		
		
		int k = 0;
		int room = 1;
		for(int j = 1 ; j < list.length; j++){
			if(start[j] > end[k])
				room++;
			k++;
		}
		
		return room;
	}
}
