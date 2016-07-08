package com.levo.ex03_methods;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class cls = Car.class;
		
		// 01: Instantiation with constructor
		Constructor[] ctors = cls.getDeclaredConstructors();
		Car car = (Car)ctors[1].newInstance(6);	// Exceptions: InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
		
		// 02: Invoking class public method
		Method method1 = cls.getDeclaredMethod("drive", char.class, int.class);	// Exceptions: NoSuchMethodException
		method1.invoke(car, 'd', 4);
		
		// 03: Invoking static method
		Method method2 = cls.getDeclaredMethod("print");
		method2.invoke(null);
		
		// 04: Invoking static method with parameter
		Method method3 = cls.getDeclaredMethod("printParam", String.class);
		method3.invoke(null, "Fenerbahce SK");
		
		// 05: Invoking private method
		Method method4 = cls.getDeclaredMethod("printSpeed");
		method4.setAccessible(true);	// use with care : This is a bad practice
		method4.invoke(car);
		method4.setAccessible(false);
//		method4.invoke(car);			// will throw Exception: IllegalAccessException
		

	}
	
	// output section separator
	private static void printLine() {
		for(int i = 0; i < 80; i++)
			System.out.print('*');
		System.out.println("\n");
	}
}
