package com.example.maths;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * 
 * @author vkukkar
 *
 *         "1 + 1" = 2 " 6-4 / 2 " = 4 "2*(5+5*2)/3+(6/2+8)" = 21 "(2+6*
 *         3+5-(3*14/7+2)*5)+3"=-12
 */

/*
 * "1 + 1" = 2 " 6-4 / 2 " = 4 "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 */
public class BasicCalculatorIII {

	public static void main(String[] args) {
		String s1 = "1 + 1";
		String s2 = " 6-4 / 2 ";
		String s3 = "2*(5+5*2)/3+(6/2+8)";
		String s4 = "(2+6* 3+5-(3*14/7+2)*5)+3";

		// System.out.println(calculate("6 - 4 / 2"));

		System.out.println(calculate(s1));
		System.out.println(calculate(s2));
		System.out.println(calculate(s3));
		System.out.println(calculate(s4));

	}

	//
	public static int calculate(String s) {

		Queue<Character> queue = new LinkedList<>();

		for (char c : s.toCharArray()) {
			if (c == ' ')
				continue;
			queue.add(c);
		}

		queue.add('+');

		return calc(queue);
	}

	private static int calc(Queue<Character> queue) {

		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		while (!queue.isEmpty()) {

			char ch = queue.remove();

			if (Character.isDigit(ch)) {
				num = num * 10 + (ch - '0');
			} else if (ch == '(') {
				num = calc(queue);
			} else {

				if (sign == '+')
					stack.push(num);
				else if (sign == '-')
					stack.push(-num);
				else if(sign == '*')
					stack.push(stack.pop() * num);
				else if(sign == '/')
					stack.push(stack.pop() / num);
				
				
				num = 0;
				sign = ch;
				
				if(ch == ')')
					break;

			}
		}
		
		int sum = 0;
		while(!stack.isEmpty())
			sum += stack.pop();
		return sum;

	}

}
