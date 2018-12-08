package com.example.array.matrix;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

	public static void main(String[] args) {

	}

	public void solveSudoku(char[][] board) {

		solve(board);
	}

	private boolean solve(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.')
					continue;

				for (int k = 1; k < 10; k++) {
					board[i][j] = (char) k;

					if (isValid(board, i, j) && solve(board))
						return true;
					board[i][j] = '.';
				}

				return false;
			}
		}

		return true;
	}

	private boolean isValid(char[][] board, int row, int col) {

		// check row
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == '.')
				continue;
			if (set.contains(board[i][col]))
				return false;
			set.add(board[i][col]);

		}

		// check column
		set.clear();
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i] == '.')
				continue;
			if (set.contains(board[row][i]))
				return false;
			set.add(board[row][i]);

		}

		set.clear();
		// check square 3 * 3
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				int x = i / 3 * 3 + i;
				int y = j / 3 * 3 + j;

				if (board[x][y] == '.')
					continue;
				if (set.contains(board[x][y]))
					return false;
				set.add(board[x][y]);
			}
		}

		return true;
	}

}
