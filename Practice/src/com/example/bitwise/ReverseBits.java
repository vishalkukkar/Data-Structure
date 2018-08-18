package com.example.bitwise;

/***
Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.*/
            		 
public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(reverseBits(4));
		System.out.println(4 >> 2);
		
	}
	
	
	public static int reverseBits(int n) {
	       int res = 0;
	       for(int i = 0; i < 4; i++) {
	    	   
	           res <<= 1;
	           res = res | (n & 1);
	           n >>= 1;
	       }
	       
	       return res;
	   }
}
