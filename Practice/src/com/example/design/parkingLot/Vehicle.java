package com.example.design.parkingLot;

public abstract class Vehicle {

	String licencePlateNo;
	Size size;

	public Vehicle(String licencePlateNo, Size size) {
		this.licencePlateNo = licencePlateNo;
		this.size = size;
	}

}
