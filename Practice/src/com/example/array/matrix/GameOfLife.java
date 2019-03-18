package com.example.array.matrix;

import java.util.Arrays;

/***
 * 
 * @author vkukkar
 *
 *
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class GameOfLife {

	public static void main(String[] args) {
		
		int[][] matrix = 
		
		{
		  {0,1,0},
		  {0,0,1},
		  {1,1,1},
		  {0,0,0}
		};
		new GameOfLife().gameOfLife(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

	public void gameOfLife(int[][] board) {

		if(board == null || board.length == 0) 
			return;
		
		int[][] res = new int[board.length][board[0].length];
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				int curr = 0;
				
				 curr = 	cal(board,i - 1, j - 1) + cal(board,i - 1, j) + cal(board,i - 1, j + 1) + 
						 	cal(board,i, j - 1) + 							cal(board,i, j + 1) +
						 	cal(board,i + 1, j - 1) + cal(board,i + 1, j) + cal(board,i + 1, j + 1);
				 
				if(board[i][j] == 1){
					 if(curr < 2){
						 res[i][j] = 0;
					 }else if(curr == 2 || curr == 3)
						 res[i][j] = 1;
					 else if(curr > 3)
						 res[i][j] = 0;
					 else
						 res[i][j] = board[i][j];
 					
				}else{
					if(curr == 3)
						res[i][j] = 1;
				}
				
			}
		}
		
		
		for(int i=0; i<board.length; i++)
			  for(int j=0; j<board[i].length; j++)
				  board[i][j]=res[i][j];
	}

	private int cal(int[][] board, int i, int j) {
		
		if(i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return board[i][j];
		return 0;
	}

}
