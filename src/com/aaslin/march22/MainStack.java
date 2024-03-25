package com.aaslin.march22;

/*
 * Author : Narendra 
 * Instantiation of StackCode class and implementing push() and pop() methods
*/

public class MainStack {
	public static void main(String[] args) {
		try {
			StackCode s = new StackCode(3);
			s.push(4);
			s.push(5);
			if (s.top + 1 == s.size) {
				System.out.println("size of the stack full");
			}
			System.out.println("Stack after pushing elements is : " + s);
			s.pop();

			if (s.top != -1) {
				System.out.println("Stack after pop() is performed " + s);
			} else if (s.top == -1) {
				System.out.println("No elements to pop");
			} else {
				System.out.println("Custom Implementation of stack");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
