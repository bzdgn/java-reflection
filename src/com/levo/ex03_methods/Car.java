package com.levo.ex03_methods;

public class Car extends Vehicle {
	
	int speed;
	char driveType;
	String[] people;
	
	public Car() {
		this(4);
	}
	
	public Car(int doors) {
		people = new String[4];
	}
	
	public int drive(char driveType, int desiredSpeed) {
		System.out.println("car#drive invoked !");
		
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
	
	private void printSpeed() {
		System.out.println("car#printSpeed [speed] = " + speed);
	}
	
	public static void print() {
		System.out.println("Hello world");
	}
	
	public static void printParam(String param) {
		System.out.println(param + " is the Best !");
	}
	
}
