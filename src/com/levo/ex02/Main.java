package com.levo.ex02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		// 01 : Type from object instance
		Class cls = Car.class;						// Car class retrieved from Type
		Class superClass = cls.getSuperclass();		// Vehicle class = superclass of Car class
		
		// 02 : Traverse on super classes
		while( superClass != null ) {
			System.out.println(superClass.getName());
			superClass = superClass.getSuperclass();
		}
		
		printLine();
		
		// 03 : Print Constructors
		Constructor[] ctors = cls.getDeclaredConstructors();
		System.out.println("Constructor\t\tParam Count\tParam Name\tParam Type");
		for(Constructor c : ctors) {
			System.out.printf( "%s\t%d\t", c.getName(), c.getParameterCount());
			Parameter[] parameters = c.getParameters();
			if(parameters.length == 0)
				System.out.printf("\t-\t\t-\n");
			
			for(Parameter param : parameters) {
				System.out.printf("\t%s\t\t%s\n", param.getName(), param.getType());
			}
		}
		
		printLine();
		
		// 04 : Print Methods with Parameters
		Method[] methods = cls.getDeclaredMethods();
		for(Method c : methods) {
			System.out.printf( "%s\t%d\t\n", c.getName(), c.getParameterCount());
			Parameter[] parameters = c.getParameters();
			if(parameters.length == 0) {
				System.out.printf("\t\t");
				System.out.printf("\t-\t\t-\n");
			}

			for(Parameter param : parameters) {
				System.out.printf("\t\t");
				System.out.printf("\t%s\t\t%s\n", param.getName(), param.getType());
			}
		}
		
		printLine();
		
		// 05 : Fields for primitive types
		System.out.println("FIELDS;\n");
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields) {
			System.out.printf("%s : (%s)\n", field.getName(), field.getType());
		}
		
		printLine();
		
		// 06 : Specific Field for Objects
		System.out.println("Specific Field : \"people\";\n");
		Field field = cls.getDeclaredField("people");	// Exceptions : NoSuchFieldException, SecurityException
		Type t = field.getType();	
		System.out.printf("%s : (%s)\n", field.getName(), t.getTypeName());
		
		// 07 : To specify if it is an Array or Not
		Class tt = field.getType();
		System.out.printf("%s : (%s)\n", field.getName(), tt.isArray());
		
	}
	
	// output section separator
	private static void printLine() {
		for(int i = 0; i < 80; i++)
			System.out.print('*');
		System.out.println("\n");
	}
}
