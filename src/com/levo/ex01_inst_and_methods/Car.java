package com.levo.ex01_inst_and_methods;

public class Car {
	
	int speed;
	char driveType;
	
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
