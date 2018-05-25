package com.example.practice;

public class convertToTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertToTitle(28));
	}
	

	public static String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;

			sb.append((char) ('A' + n % 26));
			n /= 26;

		}
		return sb.reverse().toString();

	}

}
