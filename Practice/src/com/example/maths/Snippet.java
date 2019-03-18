package com.example.maths;

public class Snippet {
	 String[] words = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
				"Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	    
	    public String numberToWords(int num) {
	            
	        if(num <= 0)
	            return "Zero";    
	    	return numberToWords1(num);
	    }
	    
	    private String numberToWords1(int num) {
	
			StringBuilder sb = new StringBuilder();
			if (num >= 1000000000)
				sb.append(numberToWords1(num / 1000000000)).append(" Billion ").append(numberToWords1(num % 1000000000));
			else if(num >= 1000000)
				sb.append(numberToWords1(num / 1000000)).append(" Million ").append(numberToWords1(num % 1000000));
			else if(num >= 1000)
				sb.append(numberToWords1(num / 1000)).append(" Thousand ").append(numberToWords1(num % 1000));
			else if(num >= 100)
				sb.append(numberToWords1(num / 100)).append(" Hundred ").append(numberToWords1(num % 100));
			else if(num >= 20)
				sb.append(words[(num - 20) / 10 + 20]).append(" ").append(numberToWords1(num % 10));
			else
				sb.append(words[num]);
	
			return sb.toString().trim();
		}
	    
}

