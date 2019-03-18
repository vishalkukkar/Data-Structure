package com.example.array.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {

	public static void main(String[] args) {

		int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };

		new WallsAndGates().wallsAndGates(rooms);
		System.out.println(Arrays.deepToString(rooms));
	}
	
	
	

	public void wallsAndGates(int[][] rooms) {

		if (rooms == null || rooms.length == 0)
			return;

		int row = rooms.length;
		int col = rooms[0].length;
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					//bfs(rooms, i, j);
					dfs(rooms,i,j,row,col,set,0);
					set = new HashSet<>();
				}
			}
		}
	}

	private void dfs(int[][] rooms, int x, int y,int row, int col,Set<String> set, int distance) {
		
		if (x >= 0 && x < row && y < col && y >= 0 && rooms[x][y] != -1 && !set.contains(x + " | " + y)){
			
			set.add(x + " | "+ y);
			if(distance < rooms[x][y])
				rooms[x][y] = distance;
			
			dfs(rooms, x + 1, y, row, col, set, distance + 1);
			dfs(rooms, x, y - 1, row, col, set, distance + 1);
			dfs(rooms, x - 1, y, row, col, set, distance + 1);
			dfs(rooms, x , y + 1, row, col, set, distance + 1);
			
		}
		
	}




	private void bfs(int[][] rooms, int x, int y) {

		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(x, y));
		int m = rooms.length;
		int n = rooms[0].length;
		Set<String> set = new HashSet<>();

		int dist = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Location curr = queue.remove();
				int val = rooms[curr.x][curr.y];
				set.add(curr.x + " | " + curr.y);
				if (dist < val)
					rooms[curr.x][curr.y] = dist;
				addNei(curr.x, curr.y, queue, m, n, rooms, set);

			}

			dist++;

		}
	}

	

	private void addNei(int x, int y, Queue<Location> queue, int row, int col, int[][] rooms, Set<String> set) {

		if (x + 1 >= 0 && x + 1 < row && y < col && y >= 0 && rooms[x + 1][y] != 0 && rooms[x + 1][y] != -1
				&& !set.contains((x + 1) + " | " + y))
			queue.add(new Location(x + 1, y));
			
		if (x >= 0 && x < row && y - 1 < col && y - 1 >= 0 && rooms[x][y - 1] != 0 && rooms[x][y - 1] != -1
				&& !set.contains(x + " | " + (y - 1)))
			queue.add(new Location(x, y - 1));

		if (x - 1 < row && x - 1 >= 0 && y < col && y >= 0 && rooms[x - 1][y] != 0 && rooms[x - 1][y] != -1
				&& !set.contains((x - 1) + " | " + y))
			queue.add(new Location(x - 1, y));

		if (x >= 0 && x < row && y + 1 < col && y + 1 >= 0 && rooms[x][y + 1] != 0 && rooms[x][y + 1] != -1
				&& !set.contains(x + " | " + (y + 1)))
			queue.add(new Location(x, y + 1));

		

	}

	public static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
