package com.example.linkedlist;

public class MergeString {

	public static String alternate(String a, String b) {
		String s = "";
		int i = 0;
		while (i < a.length() && i < b.length()) {
			s += a.charAt(i) + "" + b.charAt(i);
			i++;
		}
		while (i < a.length()) {
			s += a.charAt(i);
			i++;
		}
		while (i < b.length()) {
			s += b.charAt(i);
			i++;
		}
		return s;
	}

	public static int merge(String str1, String str2) {

		int a1[] = new int[26];
		int a2[] = new int[26];

		for (int i = 0; i < str1.length(); i++)
			a1[str1.charAt(i) - 'a']++;

		for (int i = 0; i < str2.length(); i++)
			a2[str2.charAt(i) - 'a']++;

		int res = 0;
		for (int i = 0; i < 26; i++)
			res += Math.abs(a1[i] - a2[i]);
		return res;
	}

	public static void main(String[] args) {
		String a = "two", b = "one";
	}
}
