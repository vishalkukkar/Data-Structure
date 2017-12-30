package com.example.strings;

public class OneIsPermutationOfOther {

	public static void main(String[] args) {
		String a = "abcdw";
		String b = "cbadq";
		
		int temp =  a.charAt(0) ^ b.charAt(0);
		
		for (int i = 1; i < a.length(); i++) {
			temp ^= a.charAt(i) ^ b.charAt(i);
		}
		
		
		System.out.println(temp);
	}
	
	

}
