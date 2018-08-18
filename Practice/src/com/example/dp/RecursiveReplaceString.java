package com.example.dp;

public class RecursiveReplaceString {

	// Given a string, compute recursively (no loops) a new string where all
	// appearances of "pi" have been replaced by "3.14".
	// changePi("xpix") → "x3.14x"
	// changePi("pipi") → "3.143.14"

	public static void main(String[] args) {
		System.out.println(new RecursiveReplaceString().changePi("pipi"));
	}

	public String changePi(String input) {

		return changePi(input, 0, input.length() - 1, 0, new StringBuilder());
	}

	private String changePi(String input, int start, int end, int index, StringBuilder sb) {

		if (start > end)
			return sb.toString();

		index = input.indexOf("pi", start);
		if (start == index) {
			sb.append("3.14");
			start++;
			start++;
			index = input.indexOf("pi", start);
			return changePi(input, start, end, index, sb);
		} else {
			sb.append(input.charAt(start));
			return changePi(input, start + 1, end, index, sb);
		}
	
	}

}
