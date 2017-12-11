package com.example.queue;

public class Fibo {

	public static void main(String[] args){
		
		int n = 19;
		int result = 0;
		while(n > 0){
			
			result = result + (n%10) * (n%10);
			n = n / 10;
		}
		System.out.println(result);
	}
}
