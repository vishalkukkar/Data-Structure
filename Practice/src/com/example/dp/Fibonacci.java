package com.example.dp;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		//System.out.println("enter the max value ");
		//int val = new Scanner(System.in).nextInt();
		//getFibonacci(val);
		recursiveFibo(10);
	}
	
	
	private static void recursiveFibo(int val){
		
		
		for (int i = 0; i < val; i++) {
			System.out.println(getFibo(i));
		}
	}

	private static int getFibo(int n) {
		
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		else
			return getFibo(n-1) + getFibo(n - 2);
	}


	private static void getFibonacci(int max) {
		
		//0 1 1 2 3 4 7 11
		// 0     1           1           
		// prev curr     val = prev + curr       
		// 
		int prev = 1;
		int curr = 1;
		int add = 0;
		
		System.out.print(add+" \n"+prev+" \n"+curr+"\n");
		for (int i = 0; i < max; i++) {
			add = prev + curr;
			prev = curr;
			curr = add;
			System.out.println(add);
		}
	}

}
