package com.aaslin.fourth;

import java.util.*;

/*Author : varma
Custom implementation of linkedlist*/
public class CustomLL {

	Node head;

	static class Node {

		int data;
		Node next;

		// Constructor
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// insert method for newNode
	public static CustomLL insert(CustomLL list, int data) {

		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {

			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}

		return list;
	}

	// delete method for deleting the node that contains that key
	public static CustomLL delete(CustomLL list, int key) {

		Node currentNode = list.head;

		Node previous = null;

		if (currentNode != null && currentNode.data == key) {
			list.head = currentNode.next;

			System.out.println("\n" + key + "  deleted");

			return list;
		}

		while (currentNode != null && currentNode.data != key) {

			previous = currentNode;
			currentNode = currentNode.next;
		}

		if (currentNode != null) {

			previous.next = currentNode.next;

			System.out.println("\n" + key + " deleted from the list");
		}
		if (currentNode == null) {

			System.out.println("\n" + key + " not found in the list");
		}

		return list;
	}

	// display method to print all the data in the linkedlist

	public static void display(CustomLL list) {
		Node currentNode = list.head;

		// System.out.print("\nLinkedList: ");

		while (currentNode != null) {

			System.out.print(currentNode.data + " ");

			currentNode = currentNode.next;
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		CustomLL list = new CustomLL();

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("please enter the required no.of elements in the linkedlist:");
			int elements = scanner.nextInt();
			for (int i = 0; i < elements; i++) {
				System.out.println("please enter the integer:");
				int key = scanner.nextInt();
				list.insert(list, key);
			}

			System.out.println("printing the elements in the list at intial stage:");

			list.display(list);

			System.out.println("please enter the data you wanted to delete:");

			int key = scanner.nextInt();

			delete(list, key);
		}
		System.out.println("\nupdated list:");

		list.display(list);

	}

}
