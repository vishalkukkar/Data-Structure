package com.example.arrayy;

import java.util.Arrays;

/**
 * @author vkukkar
 * 
 *         You are given an array of characters arr, which consists of sequences
 *         of characters (words) separated by space characters.
 * 
 *         How can you most efficiently reverse the order of words in the
 *         sentence? For example: [ 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm',
 *         'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
 * 
 *         would turn into: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm',
 *         'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
 * 
 *
 */
public class ReverseCharactersArray {

	public static void main(String[] args) {

		char[] array = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't',
				'i', 'c', 'e' };

		System.out.println(Arrays.toString(reverseWords(array)));

	}

	public static char[] reverseWords(char[] array) {

		int start = 0;
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] == ' '){
				reverse(array,start,i - 1);
				start = i + 1;
			}
		}

		reverse(array, start, array.length - 1);
		reverse(array, 0, array.length - 1);
		return array;
	}

	public static void reverse(char[] array, int i, int j) {

		while (i <= j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		
	}

}
