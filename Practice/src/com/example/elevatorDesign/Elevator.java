package com.example.elevatorDesign;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

	private Integer currFloor;
	private Queue<Integer> destfloors;
	
	public Elevator(Integer currFloor){
		this.currFloor = currFloor; 
		destfloors = new LinkedList<>();
	}
	
	
}
