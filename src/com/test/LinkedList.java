package com.test;

public class LinkedList {

	private Node head = null;
	private Node tail = null;
	private static int counter;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		LinkedList.counter = counter;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	// To append the element in the LinkedList
	public void appendElement(int data) {
		Node node = new Node(data);
		if (this.getHead() == null) {
			this.setHead(node);
			this.setTail(this.getHead());
		} else {
			this.getTail().setNext(node);
			this.setTail(node);
		}
		LinkedList.setCounter(getCounter() + 1);
	}

	// To remove the tail element from the linkedlist
	public void removeTail() {
		Node currentNode = this.getHead();
		if (currentNode != null) {
			if (LinkedList.getCounter() == 1) {
				this.setHead(null);
				this.setTail(null);
				LinkedList.setCounter(0);
			} else {
				for (int i = 1; i < LinkedList.getCounter() - 1; i++) {
					currentNode = currentNode.getNext();
				}
				currentNode.setNext(null);
				this.setTail(currentNode);
				LinkedList.setCounter(getCounter() - 1);
			}
		}
	}

	// To remove all element from the linkedlist that is greater than a target value
	public void removeGreaterValue(int value) {
		if (this.getHead() == null) {
			System.out.println("List is empty");
			return;
		}
		Node headNode = this.getHead();
		while (headNode.getData() > value) {
			this.setHead(headNode.getNext());
			headNode = this.getHead();
			LinkedList.setCounter(getCounter() - 1);
		}
		if (this.getHead() != null) {
			Node currentNode = this.getHead();
			Node preNode = this.getHead();
			while (currentNode.getNext() != null) {
				if (currentNode.getData() > value) {
					currentNode = currentNode.getNext();
					preNode.setNext(currentNode);
					LinkedList.setCounter(getCounter() - 1);
				} else {
					preNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
			if (currentNode.getNext() == null && currentNode.getData() > value) {
				preNode.setNext(null);
				LinkedList.setCounter(getCounter() - 1);
			}
		}
	}

	// To remove all element from the linkedlist that is greater than a target Index
	public void removeGreaterIndex(int index) {
		if (this.getHead() == null) {
			System.out.println("List is empty");
			return;
		}
		Node currentNode = this.getHead();
		if (index > LinkedList.getCounter()|| index==0) {
			System.out.println("Invalid Index");
			return;
		}
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(null);
		this.setTail(currentNode);
		LinkedList.setCounter(index);

	}

	// To get all the element from LinkedList
	public void getAll() {
		Node currentNode = this.getHead();
		if (this.getHead() == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Elements of singly linked list: ");
		while (currentNode != null) {
			System.out.print(currentNode.getData());
			currentNode = currentNode.getNext();
			if (currentNode != null) {
				System.out.print(" => ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.appendElement(6);
		linkedList.appendElement(5);
		linkedList.appendElement(6);
		linkedList.appendElement(4);
		linkedList.appendElement(7);
		linkedList.appendElement(7);
		linkedList.appendElement(4);
		linkedList.appendElement(10);
		linkedList.appendElement(3);
		linkedList.getAll();// Output:Elements of singly linked list:
		// 6 => 5 => 6 => 4 => 7 => 7 => 4 => 10 => 3
		linkedList.removeTail();
		linkedList.getAll();
		/*
		 * Output:Elements of singly linked list: 6 => 5 => 6 => 4 => 7 => 7 => 4 => 10
		 */
		linkedList.removeGreaterValue(6);
		linkedList.getAll();
		/*
		 * Output:Elements of singly linked list: 6 => 5 => 6 => 4 => 4
		 */
		linkedList.removeGreaterIndex(3);
		linkedList.getAll();
		/*
		 * Index start from 1 
		 * Output:Elements of singly linked list: 6 => 5 => 6 
		 */
	}

}
