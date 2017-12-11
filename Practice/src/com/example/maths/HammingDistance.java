package com.example.maths;

public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {

		String a = Integer.toBinaryString(x);
		String b = Integer.toBinaryString(y);

		if (a.length() > b.length()) {
			b = appendZeros(a.length() - b.length(), b);
		} else if (b.length() > a.length()) {
			a = appendZeros(b.length() - a.length(), a);
		}
		
		int i = 0;

		int count = 0;
		while (i < a.length() && i < b.length()) {
			if (a.charAt(i) != b.charAt(i))
				count++;
			i++;
		}
		return count;

	}

	private static String appendZeros(int i, String b) {
		StringBuilder sb = new StringBuilder();
		while (i > 0) {
			sb.append("0");
			i--;
		}
		sb.append(b);
		return sb.toString();
	}
}
