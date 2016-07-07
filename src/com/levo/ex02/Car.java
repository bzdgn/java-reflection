package com.levo.ex02;

public class Car extends Vehicle {
	
	int speed;
	char driveType;
	String[] people;
	
	public Car() {
		this(4);
	}
	
	public Car(int doors) {
		;
	}
	
	public int drive(char driveType, int desiredSpeed) {
		selectDrive(driveType);
		
		while(speed != desiredSpeed) {
			accelerate();
		}
		
		return speed;
	}
	
	private int accelerate() {
		return ++speed;
	}
	
	private void selectDrive(char driveType) {
		this.driveType = driveType;
	}
	
}
