package com.example.array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
 * @author vkukkar
 * 
 *         Given word = "ABCCED", return true. Given word = "SEE", return true.
 *         Given word = "ABCB", return false.
 */
public class WordSearchInMatrix {

	public static void main(String[] args) {

	char[][] board = { { 'A', 'B', 'C', 'E' }, 
							{ 'S', 'F', 'C', 'S' }, 
							{ 'A', 'D', 'E', 'E' } };

	/*	System.out.println(new WordSearchInMatrix().exist(board, "ABCCED"));*/

		/*
		System.out.println(new WordSearchInMatrix().exist(board, "ABE"));
		*/
		String[] words = {"ABCE","ADEE","EEEE"};
		System.out.println(new WordSearchInMatrix().findWords(board,words));
		System.out.println(Arrays.deepToString(board));
	}

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || word == null || word.length() == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (DFSUtil(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean DFSUtil(char[][] board, String word, int i, int j, int k) {

		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && k < word.length()) {

			if (board[i][j] == word.charAt(k) && k == word.length() - 1)
				return true;
			char c = word.charAt(k);
			if (board[i][j] == c) {
				board[i][j] = '*';
				if (DFSUtil(board, word, i, j + 1, k + 1) || DFSUtil(board, word, i, j - 1, k + 1)
						|| DFSUtil(board, word, i + 1, j, k + 1) || DFSUtil(board, word, i - 1, j, k + 1)){
					board[i][j] = c;
					return true;
				}
				board[i][j] = c;
			}
			
		}

		return false;
	}

	public List<String> findWords(char[][] board, String[] words) {

		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || words == null || words.length == 0)
			return res;

		for (String word : words) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {

					if (DFSUtil(board, word, i, j, 0)) {
						res.add(word);
					}
				}
			}
		}
		return res;

	}
}
