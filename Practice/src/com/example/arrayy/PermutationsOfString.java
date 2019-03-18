package com.example.arrayy;

import java.util.Arrays;

public class PermutationsOfString {

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		PermutationsOfString permutation = new PermutationsOfString();
		permutation.permute(str, 0, n - 1);
		
		
	}

	private void permute(String str, int l, int r) {
		
		//System.out.println("l "+l +" r "+r +"    "+str);
		
		if (l == r)
			System.out.println(" \n"+str);
		else {
			for (int i = l; i <= r; i++) {
				System.out.println(i + " "+r);
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		String s = String.valueOf(charArray);
		//System.out.println("swap "+Arrays.toString(charArray));
		return s;
	}

}
