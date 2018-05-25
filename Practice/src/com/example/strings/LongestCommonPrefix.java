package com.example.strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strs = { "c", "acc", "ccc" };
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0)
			return null;

		String longestPrefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			
			String curr = strs[i];
			
			while(curr != null && curr.indexOf(longestPrefix) != 0){
				longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
				System.out.println(longestPrefix);
			}
				
		}
		return longestPrefix;
	}

}
