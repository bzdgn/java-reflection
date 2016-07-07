package com.levo.ex01_inst_and_methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		// 01 : Type from object instance
//		Car c = new Car();
//		Class cls = c.getClass();
		
		// 01 : Type from Class
		Class cls = Car.class;
		
		// 02 : Instantiations (Object Creation)
		cls.newInstance();			// reflection :
									// We are creating an object using its Type at Run-Time
									// rather using the new keyword discovering its Type at Compile Time
									// Exceptions: InstantiationException, IllegalAccessException
		
		// 03 : Methods-I : getMethods()
												// We get declared methods which are;
												// Either the public methods of the class or
												// any public methods derived from the parent class
		Method[] methods = cls.getMethods();
		for(Method method: methods) {
			int count = method.getParameterCount();
			System.out.printf("%s (%d)%n", method.getName(), count);
		}
		
		printLine();
		
		// 04 : Methods-II : getDeclaredMethods()
												// We get declared methods which are;
												// Either the public methods of the class or
												// any public methods derived from the parent class
		Method[] declaredMethods = cls.getDeclaredMethods();
		for(Method method: declaredMethods) {
			int count = method.getParameterCount();
			System.out.printf("%s (%d)%n", method.getName(), count);
		}
		
		printLine();
		
	}
	
	// output section separator
	private static void printLine() {
		for(int i = 0; i < 80; i++)
			System.out.print('*');
		System.out.println("\n");
	}
}
