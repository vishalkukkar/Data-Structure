package com.example.strings;

public class StrStr {

	public static void main(String[] args) {

		System.out.println(strStr("aaa","aaaa"));
	}

	public static int strStr(String haystack, String needle) {
		
		if(haystack == null ||
				needle == null)
			return -1;
		
		if(needle.length() > haystack.length())
			return -1;
		
		if(haystack.length() >= 0 && needle.length() == 0)
			return 0;
		
		for (int i = 0; i < haystack.length(); i++) {
			
			if(haystack.length() - i < needle.length())
				return -1;
			
			
			int temp = i;
			for (int j = 0; j < needle.length(); j++) {
				//System.out.println(needle.charAt(j)+"  "+haystack.charAt(temp));
				if(needle.charAt(j) != haystack.charAt(temp)){
					break;
				}else{
					temp++;
				}
				System.out.println("j "+j+" "+needle.length());
				if(j == needle.length() - 1)
					return i;
			}
		}
		
		return -1;
	}
}
