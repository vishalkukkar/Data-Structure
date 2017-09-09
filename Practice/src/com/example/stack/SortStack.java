package com.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {

	static Stack<Integer> temp = new Stack<Integer>();
	

	public static Stack<Integer> sort1(Stack<Integer> s) {
		
		while(!s.isEmpty()){
			
			if(temp.isEmpty())
				temp.push(s.pop());
			else{
				
				int orgStack = s.pop();
				
				while(!temp.isEmpty()  && orgStack > temp.peek()){
					s.push(temp.pop());
				}
				
				temp.push(orgStack);
				
			}
			
		}
		
		return temp;

	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(3);
		s.push(2);
		s.push(7);
		s.push(6);

		System.out.println(Arrays.deepToString(sort1(s).toArray()));;
	}

}
