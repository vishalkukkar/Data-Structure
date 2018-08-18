package com.example.bitwise;

public class NumberOfOneBits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(1234556));
		System.out.println(hammingWeight2(1234556));
	}
	
	public static int hammingWeight2(int n) {
		
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if(getBit(n,i))
				count++;
		}
		
		return count;
		
	}

	private static boolean getBit(int n, int i) {
		
		System.out.println((n & (1 << i)));
		return (n & (1 << i)) != 0? true : false;
	}

	public static int hammingWeight(int n) {
		
		
		int count = 0;
		
		while(n > 0){
			if(n % 2 == 1)
				count++;
			n = n / 2;
		}
		return count;

	}

}
