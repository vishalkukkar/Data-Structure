package com.example.arrayy;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {

	public static void main(String[] args) {

		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
	public static int largestRectangleArea1(int[] height) {
	    if (height == null || height.length == 0) {
	        return 0;
	    }
	    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
	    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
	    
	    lessFromRight[height.length - 1] = height.length;
	    lessFromLeft[0] = -1;

	    for (int i = 1; i < height.length; i++) {
	        int p = i - 1;

	        while (p >= 0 && height[p] >= height[i]) {
	            p = lessFromLeft[p];
	        }
	        lessFromLeft[i] = p;
	    }

	    for (int i = height.length - 2; i >= 0; i--) {
	        int p = i + 1;

	        while (p < height.length && height[p] >= height[i]) {
	            p = lessFromRight[p];
	        }
	        lessFromRight[i] = p;
	    }

	    System.out.println(Arrays.toString(lessFromLeft));
	    System.out.println(Arrays.toString(lessFromRight));
	    int maxArea = 0;
	    for (int i = 0; i < height.length; i++) {
	        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
	    }

	    return maxArea;
	}

	public static int largestRectangleArea(int[] height) {

		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while(i < height.length ){
			
			
			if(stack.isEmpty() || height[i] > height[stack.peek()]){
				stack.push(i);
				i++;
			}
			else{
				
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
		}
		
		
		while(!stack.isEmpty()){
			
			int h = height[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}
}
