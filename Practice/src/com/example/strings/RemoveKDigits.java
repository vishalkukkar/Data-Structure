package com.example.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.util.Util;

public class RemoveKDigits {

	public static void main(String[] args) {

		
		String s = "av";
		char[] array1 = s.toCharArray();
		new String(array1);
		
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		
		
		List<Integer> list = new ArrayList<>(stack);
		System.out.println(Util.print(list));
		 
		    
		System.out.println(new RemoveKDigits().removeKdigits2("1234567890", 9));
	}

	public String removeKdigits(String num, int k) {

		if (num.length() == k)
			return "0";
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < num.length()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;

			}

			stack.push(num.charAt(i));
			i++;
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		// get num remove preceding 0's
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		if (sb.length() == 0)
			return "0";
		return sb.toString();

	}

	public String removeKdigits2(String num, int k) {
		int len = num.length();
		// corner case
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			// whenever meet a digit which is less than the previous digit,
			// discard the previous one
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
			i++;
		}

		// corner case like "1111"
		while (k > 0) {
			stack.pop();
			k--;
		}

		// construct the number from the stack
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();

		System.out.println(sb.toString());

		// remove all the 0 at the head
		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);
		return sb.toString();
	}

}
