package com.example.arrayy;

/**
 * @author vkukkar
 *
 *         Suppose you are at a party with n people (labeled from 0 to n - 1)
 *         and among them, there may exist one celebrity. The definition of a
 *         celebrity is that all the other n - 1 people know him/her but he/she
 *         does not know any of them.
 * 
 *         Now you want to find out who the celebrity is or verify that there is
 *         not one. The only thing you are allowed to do is to ask questions
 *         like: "Hi, A. Do you know B?" to get information of whether A knows
 *         B. You need to find out the celebrity (or verify there is not one) by
 *         asking as few questions as possible (in the asymptotic sense).
 * 
 *         You are given a helper function bool knows(a, b) which tells you
 *         whether A knows B. Implement a function int findCelebrity(n), your
 *         function should minimize the number of calls to knows.
 * 
 *         Note: There will be exactly one celebrity if he/she is in the party.
 *         Return the celebrity's label if there is a celebrity in the party. If
 *         there is no celebrity, return -1.
 */
public class FindCelebrity {

	public static void main(String[] args) {

		int n = 1;
		
		Integer p = null;
		System.out.println(p.intValue());

		System.out.println(strStr("Hello", ""));

	}
	

	public static int findCelebrity(int n) {
		return n;
	}

	/*
	 * int String
	 * 
	 * strstr(string bigString, string smallerStringToSearch) {
	 * 
	 * 
	 * }
	 */
	/*
	 * public static int strStr(String bigString, String 
)
	 * {
	 * 
	 * if(smallerStringToSearch == null || smallerStringToSearch.length() == 0)
	 * return -1;
	 * 
	 * for (int i = 0;; i++) { for (int j = 0;; j++) { if (j ==
	 * smallerStringToSearch.length()) return i; if (i + j ==
	 * bigString.length()) return -1; if (smallerStringToSearch.charAt(j) !=
	 * bigString.charAt(i + j)) break; } } }
	 */

	public static int strStr(String bigString, String smallerStringToSearch) {
		if (smallerStringToSearch == null || bigString == null)
			return -1;
		if (smallerStringToSearch.isEmpty())
			return 0;
		for (int i = 0, j = 0; i < bigString.length() && j < smallerStringToSearch.length(); i++) {
			if (bigString.charAt(i) == smallerStringToSearch.charAt(j))
				j++;
			else {
				i = i - j;
				j = 0;
			}
			if (j == smallerStringToSearch.length())
				return i - j + 1;
		}
		return -1;
	}

}
