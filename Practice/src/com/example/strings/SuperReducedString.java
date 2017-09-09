package com.example.strings;

import java.util.Arrays;

public class SuperReducedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "baab";
		char[] array = string.toCharArray();

		for (int i = 0; i < array.length-1; i++) {
			if (string.charAt(i) == string.charAt(i + 1)) {
				array[i] = ' ';
				array[i + 1] = ' ';
			}
		}
		
		System.out.println(Arrays.toString(array));

	}

}
