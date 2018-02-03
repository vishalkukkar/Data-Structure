package com.example.dp;

/**
 * 
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. Given
 * an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 */
public class CountAndSay {

	public static void main(String[] args) {

		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		
		if(n <= 0)
			return "";
			
		int i = 1;
		String curr = "1";
		
		
		while(i < n){
			int count = 1;
			
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j < curr.length(); j++) {
				if(curr.charAt(j) == curr.charAt(j - 1)){
					count++;
				}else{
					sb.append(count).append(curr.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count).append(curr.charAt(curr.length() - 1));
			curr = sb.toString();
			System.out.println(curr);
			i++;
			
		}
		return curr;

	}
}
