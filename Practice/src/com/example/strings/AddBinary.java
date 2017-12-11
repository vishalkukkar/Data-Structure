package com.example.strings;

public class AddBinary {

	public static void main(String[] args) {

		System.out.println(addBinany("11", "1"));
		System.out.println(Integer.valueOf('0'));
	}

	private static String addBinany(String a, String b) {

		if (a == null && b == null)
			return null;

		StringBuilder sb = new StringBuilder();
		int first = a.length() - 1;
		int second = b.length() - 1;
		int carry = 0;

		while (first >= 0 || second >= 0) {

			int i = 0;
			int j = 0;
			if (first >= 0) {
				char one = a.charAt(first);
				i = one == '1' ? 1 : 0;
				first--;
			}

			if (second >= 0) {
				char two = b.charAt(second);
				j = two == '0' ? 0 : 1;
				second--;
			}

			int add = i + j + carry;

			if (add >= 2) {
				sb.append(String.valueOf(add - 2));
				carry = 1;
			} else {
				sb.append(String.valueOf(add));
				carry = 0;
			}

		}

		if (carry == 1) {
			sb.append('1');
		}

		return sb.reverse().toString();
	}

}
