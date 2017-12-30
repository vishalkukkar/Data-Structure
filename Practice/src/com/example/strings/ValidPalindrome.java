package com.example.strings;

public class ValidPalindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome("1a2"));
	}

	public static boolean isPalindrome(String s) {

		char[] input = s.toLowerCase().toCharArray();

		int i = 0;
		int j = input.length - 1;

		while (i <= j) {

			int left = (int) input[i];
			int right = (int) input[j];

			if (Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right)) {

				if (left != right)
					return false;
				i++;
				j--;
			} else if (Character.isLetterOrDigit(left)) {
				j--;
			} else if (Character.isLetterOrDigit(right))
				i++;

		}

		return true;

	}
}
