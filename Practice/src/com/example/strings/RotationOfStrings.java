package com.example.strings;

public class RotationOfStrings {

	public static void main(String[] args) {

		String one = "waterbottle";
		String two = "erbottlawat";
		System.out.println(isRotation(one, two));

	}

	private static Boolean isRotation(String one, String two) {

		if (one.length() != two.length() || one == null || two == null)
			return false;

		String three = two + two;

		return three.indexOf(one) != -1;

	}
}
