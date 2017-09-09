package com.example.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfString {

	public static void main(String[] args) {

		List<String> list = letterCombinations("23");
	}

	public static List<String> letterCombinations(String digits) {

		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < digits.length(); i++) {

			for (Character c : getList(digits.charAt(i))) {
				
			}

		}
		return null;

	}

	private static List<Character> getList(char alphabet) {
		
		if(alphabet == '1'){
			List<Character> list = new ArrayList<Character>();
//			for (int i = 0; i < array.length; i++) {
//				
//			}
		}
		return null;
	}

}
