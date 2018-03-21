package com.example.dp;

public class RandomNumber {

	public static void main(String[] args) {

		/*for (int i = 1; i <= 5; ++i) {
			for (int j = 1; j <= 5; ++j) {
				System.out.println(i * 5 + j - 5);
			}
		}
		//create rand5
		System.out.println(rand7());*/
		
		String num = "0.01";
		
		Double d = 0 * new Double((16 ^ -2));
		System.out.println(d);
		for (int i = 0; i < num.length(); i++) {
			
			int c = num.charAt(i) - '0';
			int t = num.charAt(i) - 'A';
			
			System.out.println("c "+c+" t "+t);
			
			if((c >= 0 && c <= 9) || (t >= 0 && t <= 6))
				d += ((16 ^ i) * (Integer.valueOf(num.charAt(i))));
				
		}
				
		System.out.println(d);
				
		
	}

	private static int rand7() {
		
		
		
		return 0;
		
	}
}
