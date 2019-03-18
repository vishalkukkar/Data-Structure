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
		return s;
		
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
