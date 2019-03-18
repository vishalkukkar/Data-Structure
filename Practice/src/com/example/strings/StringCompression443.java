package com.example.strings;

/***
 * 
 * @author vkukkar
 *
 *
 *         Given an array of characters, compress it in-place.
 * 
 *         The length after compression must always be smaller than or equal to
 *         the original array.
 * 
 *         Every element of the array should be a character (not int) of length
 *         1.
 * 
 *         After you are done modifying the input array in-place, return the new
 *         length of the array.
 * 
 * 
 *         Follow up: Could you solve it using only O(1) extra space?
 * 
 * 
 *         Example 1:
 * 
 *         Input: ['a','a','b','b','c','c','c']
 * 
 *         Output: Return 6, and the first 6 characters of the input array
 *         should be: ['a','2','b','2','c','3']
 * 
 *         Explanation: 'aa' is replaced by 'a2'. 'bb' is replaced by 'b2'.
 *         'ccc' is replaced by 'c3'.
 * 
 * 
 *         Example 2:
 * 
 *         Input: ['a']
 * 
 *         Output: Return 1, and the first 1 characters of the input array
 *         should be: ['a']
 * 
 *         Explanation: Nothing is replaced.
 * 
 * 
 *         Example 3:
 * 
 *         Input: ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * 
 *         Output: Return 4, and the first 4 characters of the input array
 *         should be: ['a','b','1','2'].
 * 
 *         Explanation: Since the character 'a' does not repeat, it is not
 *         compressed. 'bbbbbbbbbbbb' is replaced by 'b12'. Notice each digit
 *         has it's own entry in the array.
 * 
 * 
 *         Note:
 * 
 *         All characters have an ASCII value in [35, 126]. 1 <= len(chars) <=
 *         1000.
 */
public class StringCompression443 {

	public static void main(String[] args) {

		char[] array = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		// System.out.println((9) - '0');

		char b = Character.forDigit(9, 10);
		System.out.println(b);
		// System.out.println(compress(array));

	}

	private static char[] compress(char[] array) {

		if (array == null || array.length == 0)
			return null;
		int i = 0;
		int pos = 0;
		int count = 0;

		while (i < array.length - 1) {

			count = 1;
			while (array[i] == array[i + 1]) {
				count++;
				i++;
			}
			i++;

			if (count == 1) {
				pos++;
				array[pos] = (char) Integer.parseInt(String.valueOf(count));
				pos += 2;
			} else if (count < 9) {

			} else if (count > 10) {
				pos++;
				for (char c : Integer.toString(count).toCharArray())
					array[pos++] = c;
			}

		}

		return null;
	}

}
