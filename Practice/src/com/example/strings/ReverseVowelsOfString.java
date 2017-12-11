package com.example.strings;

public class ReverseVowelsOfString {

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {

		char[] array = s.toCharArray();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {

			boolean left = isVowel(array[i]);
			boolean right = isVowel(array[j]);

			if (left && right) {
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;

				i++;
				j--;
			} else if (left) {
				j--;
			} else {
				i++;
			}

		}
		return new String(array);

	}

	private static boolean isVowel(char c) {
		if (c == 'i' || c == 'o' || c == 'a' || c == 'e' || c == 'u' || c == 'I' || c == 'O' || c == 'A' || c == 'E'
				|| c == 'U')
			return true;
		return false;
	}

}
