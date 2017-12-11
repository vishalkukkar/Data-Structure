package com.example.strings;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(getInteger("XIX"));
	}

	private static Integer getInteger(String s) {

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int n = getNum(s.charAt(i));
			if (i == 0)
				res = res + n;
			else {
				if (n > getNum(s.charAt(i - 1)))
					res = res + n - 2 * getNum(s.charAt(i - 1));
				else
					res = res + n;
			}
			// System.out.println(n);
		}
		return res;
	}

	private static int getNum(char x) {
		switch (x) {
		case 'I':
		case 'i':
			return 1;
		case 'V':
		case 'v':
			return 5;
		case 'X':
		case 'x':
			return 10;
		case 'L':
		case 'l':
			return 50;
		case 'C':
		case 'c':
			return 100;
		case 'D':
		case 'd':
			return 500;

		}
		return 0;
	}

}
