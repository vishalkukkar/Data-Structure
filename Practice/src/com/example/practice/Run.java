package com.example.practice;

public class Run {

	/**
	 * 
	 * @param args
	 *            Given a string, compute recursively a new string where
	 *            identical chars that are adjacent in the original string are
	 *            separated from each other by a "*".
	 * 
	 * 
	 *            pairStar("hello") → "hel*lo" pairStar("xxyy") → "x*xy*y"
	 *            pairStar("aaaa") → "a*a*a*a"
	 */

	public static void main(String[] args) {
		String input = "xxyy";
		System.out.println(new Run().encrypt(input));
	}

	public String encrypt(String input) {
		if (input == null || input.length() == 0)
			return null;

		return printStar(0, new StringBuilder(), input);
	}

	private String printStar(int index, StringBuilder sb, String input) {

		if (index == input.length() - 1) {
			sb.append(input.charAt(index));
			return sb.toString();
		} else if (input.charAt(index) == input.charAt(index + 1)) {
			sb.append(input.charAt(index)).append("*");
		} else {
			sb.append(input.charAt(index));
		}

		return printStar(index + 1, sb, input);
	}

}
