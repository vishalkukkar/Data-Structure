package com.example.sort;

import java.util.HashMap;
import java.util.Map;

/****
 * 
 * //https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 * https://leetcode.com/problems/custom-sort-string/description/#
 * 
 * @author vkukkar Method 3 (Use Hashing) 1. Loop through A1[], store the count
 *         of every number in a HashMap (key: number, value: count of number) .
 *         2. Loop through A2[], check if it is present in HashMap, if so, put
 *         in output array that many times and remove the number from HashMap.
 *         3. Sort the rest of the numbers present in HashMap and put in output
 *         array.
 * 
 *         Thanks to Anurag Sigh for suggesting this method.
 * 
 *         The steps 1 and 2 on average take O(m+n) time under the assumption
 *         that we have a good hashing function that takes O(1) time for
 *         insertion and search on average. The third step takes O(pLogp) time
 *         where p is the number of elements remained after considering elements
 *         of A2[].
 */
public class SortAccording {

	public static void main(String[] args) {

		String S = "cbafg";
		String T = "abcd";

		System.out.println(customSortString(S, T));

	}

	//https://leetcode.com/problems/custom-sort-string/description/#
	public static String customSortString(String S, String T) {

		if(S == null || T == null || S.length() == 0 || T.length() == 0)
			return "";
		
		StringBuilder result = new StringBuilder();
		HashMap<Character, Integer> customOrder = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (customOrder.containsKey(c)) {
				customOrder.put(c, customOrder.get(c) + 1);
			} else
				customOrder.put(c, 1);
		}
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(customOrder.containsKey(c)){
				int count = customOrder.get(c);
				while(count > 0){
					result.append(c);
					count--;
				}
				customOrder.remove(c);
			}
		}
		
		for(Map.Entry<Character, Integer> map : customOrder.entrySet()){
			char c = map.getKey();
			int count = map.getValue();
			
			while(count > 0){
				result.append(c);
				count--;
			}
		}

		return result.toString();

	}

}
