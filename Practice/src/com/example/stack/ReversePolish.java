package com.example.stack;

import java.util.Stack;

public class ReversePolish {

	public static void main(String[] args) {
		String[] array = { "0", "3", "/" };
		//String[] token = {"2", "1", "+", "3", "*"};
		//System.out.println(evalRPN(token));
		System.out.println(evalRPN(array));

	}

	public static int evalRPN(String[] tokens) {

		//+, -, *, /
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == "*" || tokens[i] == "/" || tokens[i] == "+" || tokens[i] == "-"){

				int j = stack.isEmpty() ? 0 :stack.pop();
				int k = stack.isEmpty() ? 0 : stack.pop();
				
					
					if(tokens[i] == "*") stack.push(j * k);
					if(tokens[i] == "/") stack.push( k / j);
					if(tokens[i] == "+") stack.push(j + k);
					if(tokens[i] == "-") stack.push(k - j);
			}else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}

		if(!stack.isEmpty())
			return stack.pop();
		return 0;
	}

}
