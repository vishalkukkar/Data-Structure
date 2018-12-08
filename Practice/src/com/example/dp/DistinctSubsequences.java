package com.example.dp;

import java.util.Arrays;

import com.util.Util;

public class DistinctSubsequences {

	/***
	 * 
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of S which equals T.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Example 1:
	 * 
	 * Input: S = "rabbbit", T = "rabbit" Output: 3 Explanation:
	 * 
	 * As shown below, there are 3 ways you can generate "rabbit" from S. (The
	 * caret symbol ^ means the chosen letters)
	 * 
	 * rabbbit ^^^^ ^^
	 * 
	 * rabbbit ^^ ^^^^
	 * 
	 * rabbbit ^^^ ^^^
	 * 
	 * Example 2:
	 * 
	 * Input: S = "babgbag", T = "bag" i Output: 5 Explanation:
	 * 
	 * As shown below, there are 5 ways you can generate "bag" from S. (The
	 * caret symbol ^ means the chosen letters)
	 * 
	 * babgbag ^^ ^ babgbag ^^ ^ babgbag ^ ^^ babgbag ^ ^^ babgbag ^^^
	 */
	public static void main(String[] args) {

		String S = "rabbbit";
		String T = "rabbit";

		int i = (int) Math.sqrt(2);
		int[][] ponits = {
			{-2, -3,   3}, 
            {-5, -10,  1}, 
            {10,  30, -5} 
          };
		
		/*
		 * 
		 {
		 {7, 5, 2}, 
		 {6, 11, 5}, 
		 {1, 1, 6}
		 }
		 
		 *
		 */
		System.out.println(minInitialPoints(ponits,3,3));
	}

	static int minInitialPoints(int points[][], int R, int C) {
		// dp[i][j] represents the minimum initial points player
		// should have so that when starts with cell(i, j) successfully
		// reaches the destination cell(m-1, n-1)
		int dp[][] = new int[R][C];
		int m = R, n = C;

		// Base case
		dp[m - 1][n - 1] = points[m - 1][n - 1] > 0 ? 1 : Math.abs(points[m - 1][n - 1]) + 1;
		System.out.println(Arrays.deepToString(dp));
		
		// Fill last row and last column as base to fill
		// entire table
		for (int i = m - 2; i >= 0; i--)
			dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - points[i][n - 1], 1);
		
		System.out.println(Arrays.deepToString(dp));
		
		for (int j = n - 2; j >= 0; j--){
			dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - points[m - 1][j], 1);
			
		}
		
		System.out.println(Arrays.deepToString(dp));
		

		// fill the table in bottom-up fashion
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int min_points_on_exit = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
			}
		}

		System.out.println(Arrays.deepToString(dp));
		return dp[0][0];
	}

	static int findSubsequenceCount(String S, String T) {
		int m = T.length();
		int n = S.length();

		// T can't appear as a subsequence in S
		if (m > n)
			return 0;

		// mat[i][j] stores the count of
		// occurrences of T(1..i) in S(1..j).
		int mat[][] = new int[m + 1][n + 1];

		// Initializing first column with
		// all 0s. An emptystring can't have
		// another string as suhsequence
		for (int i = 1; i <= m; i++)
			mat[i][0] = 0;

		// Initializing first row with all 1s.
		// An empty string is subsequence of all.
		for (int j = 0; j <= n; j++)
			mat[0][j] = 1;

		// Fill mat[][] in bottom up manner
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// If last characters don't match,
				// then value is same as the value
				// without last character in S.
				if (T.charAt(i - 1) != S.charAt(j - 1))
					mat[i][j] = mat[i][j - 1];

				// Else value is obtained considering two cases.
				// a) All substrings without last character in S
				// b) All substrings without last characters in
				// both.
				else
					mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
			}
		}

		System.out.println(Util.print(mat));
		/*
		 * uncomment this to print matrix mat
		 * 
		 * for (int i = 1; i <= m; i++, cout << endl) for (int j = 1; j <= n;
		 * j++) System.out.println ( mat[i][j] +" ");
		 */
		return mat[m][n];
	}

}
