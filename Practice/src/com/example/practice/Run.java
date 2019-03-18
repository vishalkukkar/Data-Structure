package com.example.practice;

public class Run {

	/**
	 * 
	 * @param args
	 *            Given a string, compute recursively a new string where
	 *            identical chars that are adjacent in the original string are
	 *            separated from each other by a "*".
	 * 
	 * 
	 *            pairStar("hello") → "hel*lo" pairStar("xxyy") → "x*xy*y"
	 *            pairStar("aaaa") → "a*a*a*a"
	 */

	public static void main(String[] args) {
	
		String prev = "1/13";
		String curr = "1/13";
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int index = prev.indexOf("/");
		for (int i = 0; i < prev.length(); i++) {
			if(i < index){
				sb1.append(prev.charAt(i));
			}else if(i > index){
				sb2.append(prev.charAt(i));
			}
		}
		
		
		int x1 = Integer.valueOf(sb1.toString());
		int y1 = Integer.valueOf(sb2.toString());
		
		sb1.setLength(0);
		sb2.setLength(0);
		
		for (int i = 0; i < curr.length(); i++) {
			if(i < index){
				sb1.append(curr.charAt(i));
			}else if(i > index){
				sb2.append(curr.charAt(i));
			}
		}
		
		int x2 = Integer.valueOf(sb1.toString());
		int y2 = Integer.valueOf(sb2.toString());
		
		System.out.println((x1 + x2)+"/"+(y1 + y2));
	}



}
