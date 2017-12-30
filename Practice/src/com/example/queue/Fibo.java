package com.example.queue;

public class Fibo {

	public static void main(String[] args){
		String string = "11011000";
		System.out.println((string));
	}

	public static String largestMagical(String binString) {

		int n = binString.length();
		int maxInd = -1;
		int maxLen = -1;
		int maxVal = -1;
		for (int i = 1; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int mag = ismagic(binString, i, j);
				if (mag > maxVal && maxVal > -1) {
					String nq = "";
					String t1 = binString.substring(maxInd, maxInd + maxLen);
					String t2 = binString.substring(i, j + 1);
					String pre1 = binString.substring(0, maxInd);
					String po1 = binString.substring(j+1, n);
					String mi1 = binString.substring(maxInd + maxLen+1, i + 1);

					nq = pre1;
					nq += t2;
					nq += mi1;
					nq += t1;
					nq += po1;

					binString = (nq);
				} else if (mag > maxVal && maxVal == -1) {
					maxInd = i;
					maxLen = j - i + 1;
					maxVal = mag;
					break;
				}
			}
		}
		return binString;
	}

	/*
	 * Check if string is magical substring for given index i,j
	 */
	public static int ismagic(String str, int i, int j) {
		if (i == j)
			return -1;
		String bis = str.substring(i, j+1);
		if (bis.length() == 0)
			return -1;

		int bi = Integer.parseInt(bis, 2);
		int count1 = 0;
		int count0 = 0;

		int n = bis.length()-1;
		while (n >= 0) {
			if (((bi & (1 << n)) != 0) && ( (bi & (1 << n)) == 1 || (bi & (1 << n)) % 2 == 0))
				count1++;
			else
				count0++;

			if (count1 < count0)
				return -1;
			n--;
		}
		if (count1 == count0)
			return Integer.parseInt(bis);
		return -1;
	}
}
