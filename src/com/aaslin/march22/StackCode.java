package com.aaslin.march22;

/*
 * Author : Narendra 
 * Custom implementation of push() and pop() methods 
 */

public class StackCode {
	int size;
	int array[];
	int top = -1;

	StackCode(int size) {
		this.size = size;
		array = new int[size];
	}

	void push(int X) {
		if (top + 1 == size) {
			System.out.println("Stack Overflow");
		} else {
			top = top + 1;
			if (array.length > top)
				array[top] = X;
		}
	}

	void pop() {
		if (top == -1) {
			System.out.println("Stack Underflow");
		} else {
			top--;
		}
	}
	@Override
	public String toString() {

		String Ans = "";
		for (int i = 0; i < top; i++) {
			Ans += array[i] + " -> ";
		}

		Ans += array[top];
		return Ans;
	}

}
