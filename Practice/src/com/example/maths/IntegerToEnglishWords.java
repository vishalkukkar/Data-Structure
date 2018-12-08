package com.example.maths;

public class IntegerToEnglishWords {

	public static void main(String[] args) {

		int number = 1234;
		System.out.println(new IntegerToEnglishWords().numberToWords(1));

	}

	String[] words = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thriteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eightteen", "Nineteen", "Twenty",
			"Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eightty", "Ninety" };

	public String numberToWords(int num) {
		return numberToWords1(num);

	}

	private String numberToWords1(int num) {

		StringBuilder sb = new StringBuilder();
		if (num >= 1000000000)
			sb.append(num / 1000000000).append(" Billion ").append(numberToWords(num % 1000000000));
		else if(num >= 1000000)
			sb.append(num / 1000000).append(" Million ").append(numberToWords(num % 1000000));
		else if(num >= 1000)
			sb.append(num / 1000).append(" Thousand ").append(numberToWords(num % 1000));
		else if(num >= 100)
			sb.append(num / 100).append(" Hundred ").append(numberToWords(num % 100));
		else if(num >= 20)
			sb.append(words[(num - 20) / 10 + 20]).append(" ").append(numberToWords(num % 10));
		else
			sb.append(words[num]);

		return sb.toString();
	}
}
