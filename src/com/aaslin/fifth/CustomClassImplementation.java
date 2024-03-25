package com.aaslin.fifth;

import java.util.HashSet;
import java.util.Set;
/* * @author varma*
 **Create a custom class to store custom objects in a set*
 */
// Custom class

public class CustomClassImplementation {
	public static void main(String[] args) {
		// Creating a Set to store CustomObjects
		Set<CustomClass> customObjectSet = new HashSet<>();

		// Creating custom objects
		CustomClass obj1 = new CustomClass(1, "VARMA");
		CustomClass obj2 = new CustomClass(2, "DHARMA");

		customObjectSet.add(obj1);
		customObjectSet.add(obj2);
		for (CustomClass obj : customObjectSet) {
			System.out.println(obj.getId() + " " + obj.getName());
		}
	}
}