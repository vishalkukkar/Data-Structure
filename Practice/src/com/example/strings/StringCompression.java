package com.example.strings;

//https://leetcode.com/problems/string-compression/description/
public class StringCompression {

	public static void main(String[] args) {
		// String str = 'aabcccccaaa';
		char[] array = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		System.out.println(compress(array));
		// System.out.println(CompressedString(str));
	}

	public static int compress(char[] chars) {

		if (chars == null || chars.length == 0)
			return 0;
		int i = 0;
		int replaceIndex = 0;
		while (i < chars.length) {
			char c = chars[i];
			int j = i + 1;
			// for single char dont't modify chars array
			if (j < chars.length && chars[j] != chars[j - 1]) {
				i++;
				replaceIndex++;
				continue;
			}
			
			replaceIndex++;
			int count = 1;
			while (j < chars.length && chars[j] == c) {
				j++;
				count++;
			}
			
			char[] temp = String.valueOf(count).toCharArray();
			int k = 0;
			while (k < temp.length) {
				System.out.println("re "+replaceIndex);
				chars[replaceIndex] = temp[k];
				k++;
				replaceIndex++;
			}
			i = j;
			
			System.out.println("i "+i+"\n\n");
		}
		System.out.println(new String(chars));
		return replaceIndex;
	}

	private static String CompressedString(String str) {

		if (str == null || str.length() == 0)
			return str;

		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < str.length()) {
			int count = 1;
			int j = i + 1;
			char c = str.charAt(i);
			sb.append(c);
			while (j < str.length() && str.charAt(j) == c) {
				count++;
				j++;
			}
			sb.append(count);
			i = j;
		}
		return sb.toString();
	}

}
