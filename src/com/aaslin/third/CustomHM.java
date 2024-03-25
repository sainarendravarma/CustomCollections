package com.aaslin.third;

import java.util.Scanner;

public class CustomHM<K, V> {

	private int capacity;
	// private int capacity = 16;

	private Entry<K, V>[] table;

	/*
	 * public CustomHashMap() { table = new Entry[capacity]; }
	 */

	public CustomHM(int capacity) { // Initial capacity of the hash table
		this.capacity = capacity;
		table = new Entry[capacity];
	}

	// put method
	public void put(K key, V value) {
		int index = index(key);
		Entry newEntry = new Entry(key, value, null);
		if (table[index] == null) {
			table[index] = newEntry;
		} else {
			Entry<K, V> previousNode = null;
			Entry<K, V> currentNode = table[index];
			while (currentNode != null) {
				if (currentNode.getKey().equals(key)) {
					currentNode.setValue(value);
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if (previousNode != null)
				previousNode.setNext(newEntry);
		}
	}

	private int index(K key) {
		if (key == null) {
			return 0;
		}
		return Math.abs(key.hashCode() % capacity);
	}

	// get method
	public V get(K key) {
		V value = null;
		int index = index(key);
		Entry<K, V> entry = table[index];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				value = entry.getValue();
				break;
			}
			entry = entry.getNext();
		}
		return value;
	}

	// display method for printing
	public void display() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> currentNode = table[i];
				while (currentNode != null) {
					System.out.println(
							String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	public static void main(String[] args) {

		CustomHM<Integer, String> map = new CustomHM<Integer, String>(16); // Initial capacity of the hashtable
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("please enter the required no.of elements in the map:");
			int elements = scanner.nextInt();
			for (int i = 0; i < elements; i++) {
				System.out.println("please enter the integer:");
				int key = scanner.nextInt();
				System.out.println("please enter the string:");
				String value = scanner.next();
				map.put(key, value);
			}

			System.out.println("priting all the values in the map:");
			map.display();

			System.out.println("please enter a key in order get any value from key:");
			int key = scanner.nextInt();

			System.out.println("value of key " + key + " is : " + map.get(key));
		}

	}

}
