package com.example.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidParenthesis {

	public static void main(String[] args) {

		String string = "{{{({[]})}}}";
		System.out.println(isValidParenthesis(string));
	}

	private static Boolean isValidParenthesis(String s) {

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (map.containsKey(temp))
				stack.push(temp);
			else {
				if (map.containsValue(temp) && !stack.isEmpty() && map.get(stack.peek()) == temp)
					stack.pop();
				else
					return false;
			}
		}

		return stack.isEmpty();
	}

}
