package com.example.array.matrix;

public class BattleShipsInBoard {

	public static void main(String[] args) {

	}

	public int countBattleships(char[][] board) {

		if (board == null || board.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (checkCurrent(board[0][0])) {
					count++;
				}
			}
		}
		return 0;
	}

	private boolean checkCurrent(char c) {
		return false;
	}
}
