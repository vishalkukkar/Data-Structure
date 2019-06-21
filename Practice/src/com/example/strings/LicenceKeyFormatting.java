package com.example.strings;

public class LicenceKeyFormatting {
	/**
	 * Input: S = "5F3Z-2e-9-w", K = 4
	 * 
	 * Output: "5F3Z-2E9W"
	 * 
	 * Explanation: The string S has been split into two parts, each part has 4
	 * characters. Note that the two extra dashes are not needed and can be
	 * removed.
	 * 
	 **/
	public static void main(String[] args) {
		
		String S = "--a-a-a-a--";
		int K = 2;
		
		 S = "2-5g-3-J";
		 K = 2;

		
		System.out.println(new LicenceKeyFormatting().licenseKeyFormatting(S, K));

	}

	public String licenseKeyFormatting(String S, int K) {

		if(S == null) return S;
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		int i = S.length() - 1;
		while(i >= 0){
			char c = S.charAt(i);
			if(S.charAt(i) != '-'){
				sb.append(c);
				count++;
			}
			
			if(count == K){
				count = 0;
				sb.append("-");
			}
			
			i--;
		}
		
		String temp = sb.reverse().toString().toUpperCase();
		if(temp.charAt(0) == '-'){
			temp = temp.substring(1, temp.length());
		}
		
		return temp;

	}
}
