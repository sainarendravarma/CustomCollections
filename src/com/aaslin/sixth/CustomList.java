package com.aaslin.sixth;

/**
 * Custom Implementation of list*
 * 
 * @author Varma
 */

public class CustomList<T> {
	private Object[] elements;
	private int size;
	private static final int cap = 10;

	public CustomList() {
		elements = new Object[cap];
		size = 0;
	}

	public void add(T element) {
		ensureCapacity();
		elements[size++] = element;
	}

	public T get(int index) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		T element = (T) elements[index];
		return element;
	}

// removes the elements at the specific index
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size--;
	}

	public int size() {
		return size;
	}

// if the array is full it creates a new array 
	private void ensureCapacity() {
		if (size == elements.length) {
			Object[] newElements = new Object[size * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}

	// checks whether the index is in valid range
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	public static void main(String[] args) {
		CustomList<Integer> list = new CustomList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		System.out.println("Element at index 1: " + list.get(1));

		list.remove(1);
		System.out.println("Size after removal: " + list.size());
	}
}