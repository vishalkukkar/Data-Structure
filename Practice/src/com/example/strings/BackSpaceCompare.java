package com.example.strings;

public class BackSpaceCompare {

	public static void main(String[] args) {

		String S = "y#fo##f";

		String T = "y#f#o##f";

		System.out.println(new BackSpaceCompare().backspaceCompare(S, T));

	}

	public boolean backspaceCompare(String S, String T) {

		return calc(S).equals(calc(T));
	}

	private String calc(String s) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '#' && sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);

			} else if (s.charAt(i) != '#') {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}

}
