package com.levo.ex04_fields;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException {
		Class cls = Car.class;
		
		Car car = (Car) cls.newInstance();
		
		// 01: Getting Field
		Field field1 = cls.getDeclaredField("speed");	// Exceptions: NoSuchFieldException, SecurityException
		Object obj = field1.get(car);
		System.out.println("Field 'speed' Before : " + obj);
		
		car.drive('D', 42);
		
		obj = field1.get(car);
		System.out.println("Field 'speed' After  : " + obj);
		
		printLine();
		
		// 02: Setting Field
		field1.set(car, 36);
		obj = field1.get(car);
		System.out.println("Field 'speed' Set To : " + obj);
		
		// 03: Getting&Setting Array Field
		Field field2 = cls.getDeclaredField("people");
		
		Array.set(field2.get(car), 0, "Levent");	// set
		Array.set(field2.get(car), 1, "Bzdgn");		// set
		
		Object obj2 = Array.get(field2.get(car), 1);// get
		
		System.out.println("1st element of 'people' field: " + obj2);
		
		printLine();
		
		// 04: About getting class of an Array;
		Class clazz = String[].class;
		
		clazz = Class.forName("[I");							// Exception: ClassNotFoundException
		System.out.println("Class : " + clazz.getName());
		
		clazz = Class.forName("[Ljava.lang.String;");			// Exception: ClassNotFoundException
		System.out.println("Class : " + clazz.getName());
		
		clazz = Class.forName("[Ljava.lang.Integer;");			// Exception: ClassNotFoundException
		System.out.println("Class : " + clazz.getName());
		
	}
	
	// output section separator
	private static void printLine() {
		for(int i = 0; i < 80; i++)
			System.out.print('*');
		System.out.println("\n");
	}
}
