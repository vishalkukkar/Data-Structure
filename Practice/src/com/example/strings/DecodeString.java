package com.example.strings;

import java.util.StringTokenizer;

/***
 * 
 * @author vkukkar Given an encoded string, return it's decoded string.
 * 
 *         The encoding rule is: k[encoded_string], where the encoded_string
 *         inside the square brackets is being repeated exactly k times. Note
 *         that k is guaranteed to be a positive integer.
 * 
 *         You may assume that the input string is always valid; No extra white
 *         spaces, square brackets are well-formed, etc.
 * 
 *         Furthermore, you may assume that the original data does not contain
 *         any digits and that digits are only for those repeat numbers, k. For
 *         example, there won't be input like 3a or 2[4].
 * 
 *         Examples:
 * 
 *         s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return
 *         "accaccacc". s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
 */
public class DecodeString {

	public static void main(String[] args) {

		/*String s1 = "3[a]2[bc]";
		System.out.println(new DecodeString().decodeString(s1));*/

		String s2 = "3[a2[c]]";
		System.out.println(new DecodeString().decodeString(s2));

		/*4*/
	}

	public String decodeString(String s) {
        return decodeStringRecursive(s);
    }
    
	int i = 0;
    private String decodeStringRecursive(String s) {
        String decoded = "";
        while (i < s.length() && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (Character.isDigit(s.charAt(i))) {
                    n = 10 * n + s.charAt(i) - '0';
                    i++;
                }
                
                i++;
                String str = decodeStringRecursive(s);
                System.out.println(str);
                while (n > 0) {
                    decoded += str;
                    n--;
                }
            } else {
                decoded += s.charAt(i);
               // System.out.println(decoded);
            }
            i++;
        }
        return decoded;
    }

}
