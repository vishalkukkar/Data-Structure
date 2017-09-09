package com.example.strings;

public class Zigzag {

	public static void main(String[] args) {
		String string = "P   A   H   N" + "A P L S I I G" + "Y   I   R";
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println("PAYPALISHIRING");

	}

	public static String convert(String s, int numRows) {
		StringBuilder[] stb = new StringBuilder[numRows];
		StringBuilder out = new StringBuilder();
		int index = 0;
		int i = 0;
		for (int j = 0; j < numRows; j++)
			stb[j] = new StringBuilder();
		for (index = 0; index < s.length() && i < numRows; index++) {
			i = 0;
			if (index % 4 == 0) // add them to the first row
				stb[i].append(s.charAt(index));
			i++;
			if (index % 2 != 0) // add them to odd row
				stb[i].append(s.charAt(index));
			i++;
			if (index % 2 == 0 && index % 4 != 0) // add them to the 2nd row
				stb[i].append(s.charAt(index));
		}
		for (int j = 0; j < numRows; j++)
			out.append(stb[j]);

		return out.toString();
	}
}
