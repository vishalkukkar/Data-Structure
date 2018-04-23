package com.example.stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(e.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {

			String curr = tokens[i];

			if (checkIfNumber(curr)) {
				stack.push(Integer.valueOf(curr));
			} else {

				Integer a = stack.pop();
				Integer b = stack.pop();

				Integer res = calculate(a, b, curr);
				stack.push(res);
			}
		}

		return !stack.isEmpty() ? stack.pop() : 0;

	}

	private Integer calculate(Integer a, Integer b, String expression) {

		if (expression.equals("+"))
			return a + b;
		else if (expression.equals("-"))
			return b - a;
		else if (expression.equals("/"))
			return b / a;
		else
			return b * a;
	}

	private boolean checkIfNumber(String curr) {

		if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/"))
			return false;
		return true;
	}

}
