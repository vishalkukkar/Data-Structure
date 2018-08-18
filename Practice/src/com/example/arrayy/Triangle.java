package com.example.arrayy;

import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).*/

public class Triangle {

	public static void main(String[] args) {

	}

	public int minimumTotal(List<List<Integer>> triangle) {
		
		if(triangle == null || triangle.size() == 0) return 0;
		int sum = 0;
		
		for (int i = 0; i < triangle.size(); i++) {
			
			List<Integer> list = triangle.get(i);
			
			if(list == null) 
				continue;
			sum += getSum(list);
		}
		return sum;
	}

	private int getSum(List<Integer> list) {

		int min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(min,list.get(1));
		}
		return min;
	}

}
