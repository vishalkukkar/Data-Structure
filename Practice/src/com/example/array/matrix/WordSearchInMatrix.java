package com.example.array.matrix;

import java.util.Arrays;

/***
 * 
 * @author vkukkar
 * 
 *         Given word = "ABCCED", return true. Given word = "SEE", return true.
 *         Given word = "ABCB", return false.
 */
public class WordSearchInMatrix {

	public static void main(String[] args) {

		char[][] board = { 	{ 'A', 'B', 'C', 'E' }, 
							{ 'S', 'F', 'C', 'S' }, 
							{ 'A', 'D', 'E', 'E' } };
		
		System.out.println(new WordSearchInMatrix().exist(board, "ABCCED"));
		
		System.out.println(Arrays.deepToString(board));
		System.out.println(new WordSearchInMatrix().exist(board, "ABCCED"));
	}

	public boolean exist(char[][] board, String word) {

		if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
		
		boolean result = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if(DFSUtil(board,word,i,j,0)){
					result = true;
				}
			}
		}
		return result;

	}
	

	private boolean DFSUtil(char[][] board, String word, int i, int j, int k) {

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;

		if (board[i][j] == word.charAt(k)) {

			char temp = board[i][j];
			board[i][j] = '#';

			if (k == word.length() - 1)
				return true;
			else if (DFSUtil(board, word, i - 1, j, k + 1) || DFSUtil(board, word, i + 1, j, k + 1)
					||  DFSUtil(board, word, i, j - 1, k + 1) || DFSUtil(board, word, i, j + 1, k + 1)) {
				return true;
			}

			board[i][j] = temp;
		}
		return false;
	}
}
