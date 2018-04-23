package com.example.stack;

/***
 * //https://www.geeksforgeeks.org/program-evaluate-simple-expressions/
 * 
 * @author vkukkar Program to evaluate simple expressions You are given a string
 *         that represent an expression of digits and operands. E.g. 1+2*3,
 *         1-2+4. You need to evaluate the string or the expression. NO BODMAS
 *         is followed. If the expression is of incorrect syntax return -1. Test
 *         cases: a) 1+2*3 will be evaluated to 9. b) 4-2+6*3 will be evaluated
 *         to 24. c) 1++2 will be evaluated to -1(INVALID). Also, in the string
 *         spaces can occur. For that case we need to ignore the spaces. Like :-
 *         1*2 -1 is equals to 1.
 */
public class EvaluateSimpleExpression {

	public static void main(String[] args) {

		EvaluateSimpleExpression e = new EvaluateSimpleExpression();
		String[] expression = { "1+2*3", "4-2+6*3", "1++2", "1*2 -1" };

		for (int i = 0; i < expression.length; i++) {
			System.out.println(e.evaluate(expression[i]));
		}
	}

	private Integer evaluate(String string) {

		if (string == null || string.length() == 0)
			return null;

		Integer res = 0;
		Integer opd1 = Integer.valueOf(string.charAt(0));
		for (int i = 1; i < string.length() - 2; i = i + 2) {

			char operator = string.charAt(i);
			Integer opd2 = Integer.valueOf(string.charAt(i + 1));

			if (checkIfOperator(operator)) {

				res = res + calculate(opd1, opd2, operator);
				opd1 = res;
			} else
				return -1;

		}
		return res;
	}

	private Integer calculate(Integer a, Integer b, char expression) {

		if (expression == '+')
			return b + a;
		else if (expression == '-')
			return b - a;
		else if (expression == '/')
			return b / a;
		else 
			return b * a;  
	}

	private boolean checkIfOperator(char curr) {

		if (curr == '+' || curr == '-' || curr == '*' || curr == '/')
			return true;
		return false;
	}

}
