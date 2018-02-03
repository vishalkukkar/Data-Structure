package com.example.strings;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/description/ Given a
 * positive integer, return its corresponding column title as appear in an Excel
 * sheet.
 * 
 * For example:
 * 
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
 * 
 * @author vkukkar
 *
 */
public class ExcelSheetToColumnTitle {

	public static void main(String[] args) {

		System.out.println(convertToTitle(28));
	}

	public static String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;

			sb.append((char)('A' + n % 26));
			n /= 26;

		}
		return sb.reverse().toString();

	}
}
