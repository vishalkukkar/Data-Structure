package com.example.dp;

public class CountAndSay {

	public static void main(String[] args) {

		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n) {

		int index = 1;
		int curr = 1;
		while (index <= n) {
			String str = String.valueOf(curr);
			if (str.length() == 1) {
				curr = Integer.valueOf(str + str);
				index++;
				continue;
			}

			int size = str.length();
			StringBuilder sb = new StringBuilder();
			int i = 1;
			int count = 1;
			while (size > 0) {

				if (str.charAt(i) == str.charAt(i - 1)) {
					count++;
				}
			}
		}
		return null;
	}

}
