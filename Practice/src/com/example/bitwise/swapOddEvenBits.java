package com.example.bitwise;

public class swapOddEvenBits {

	public static void main(String[] args) {
		
		System.out.println(swapBits(5));
		System.out.println(0xAAAAAAAA);
		// 0101  = 5
		//1010   = 10
	}

	public static int swapBits(int x) {
		
		
		int evenBits = x & 0xAAAAAAAA;
		int oddBits = x & 0x55555555;
		
		evenBits = evenBits >> 1;
		oddBits = oddBits << 1;
		
		return evenBits | oddBits;
		
		
	}

}
