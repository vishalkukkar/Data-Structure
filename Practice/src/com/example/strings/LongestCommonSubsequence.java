package com.example.strings;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
	}

	private int lcs(char[] x, char[] y, int m, int n) {

		int[][] array = new int[m + 1][n + 1];

		for (int i = 0; i <= x.length; i++) {
			for (int j = 0; j <= y.length; j++) {

				if (i == 0 || j == 0)
					array[i][j] = 0;
				else if (x[i - 1] == y[j - 1])
					array[i][j] = 1 + array[i - 1][j - 1];
				else
					array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);

			}
		}

		return array[m][n];
	}
}
