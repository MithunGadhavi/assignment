package com.evaluator.car.service;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class Car {
	
	private int carNumber;
	
	private double carPrice;
	
	private int basePrice;
	public int getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNoOfWheelDrive() {
		return noOfWheelDrive;
	}
	public void setNoOfWheelDrive(int noOfWheelDrive) {
		this.noOfWheelDrive = noOfWheelDrive;
	}
	public boolean isAmphibious() {
		return isAmphibious;
	}
	public void setAmphibious(boolean isAmphibious) {
		this.isAmphibious = isAmphibious;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	private String color;
	private int noOfWheelDrive;
	private boolean isAmphibious;

}
