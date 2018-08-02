package com.example.dp;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		Long s = System.currentTimeMillis();
//		System.out.println(longestPalindrome(
//				"abcabacb"));

		
		System.out.println("abcabacb".substring(3,6));
		//System.out.println("time :"+(System.currentTimeMillis() - s));
	}

	public static String longestPalindrome(String s) {

		String string = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {

			// even string
			String temp1 = isPalidrome(i, i, s);
			if (temp1.length() > string.length()) {
				string = temp1;
			} 

			// odd string
			String temp2 = isPalidrome(i, i + 1, s);
			if (temp2.length() > string.length()) {
				string = temp2;
			}
		}
		return string;
	}

	private static String isPalidrome(int i, int j, String s) {

		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j))
				break;
			i--;
			j++;
		}

		System.out.println(i + " "+ j);
		System.out.println(s.substring(i + 1, j));
		return s.substring(i + 1, j);
	}

}
