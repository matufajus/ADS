package main.dataStructures;

import java.util.NoSuchElementException;

public class LinkedList {

	private class Node {
		public int number;
		public Node nextNode;

		public Node(int number) {
			this.number = number;
		}
	}

	private Node head;
	private Node tail;

	public void print() {
		Node curNode = head;
		System.out.print("[");
		if (head != null) {
			do {
				System.out.print(curNode.number);
				if (curNode.nextNode != null) {
					System.out.print(", ");
				}
				curNode = curNode.nextNode;
			} while (curNode != null);
		}
		System.out.print("]");
	}

	public void addFirst(int numb) {
		Node node = new Node(numb);
		if (head == null) {
			head = tail = node;
		} else {
			node.nextNode = head;
			head = node;
		}
	}

	public void addLast(int numb) {
		Node node = new Node(numb);
		if (head == null) {
			head = tail = node;
		} else {
			tail.nextNode = node;
			tail = node;
		}
	}

	public void deleteFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			head = tail = null;
		} else {
			Node node = head.nextNode;
			head.nextNode = null;
			head = node;
		}
	}

	public void deleteLast() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			head = tail = null;
		} else {
			Node node = head;
			while (node.nextNode != tail) {
				node = node.nextNode;
			}
			tail = node;
			tail.nextNode = null;
		}
	}

	public boolean contains(int number) {
		return indexOf(number) != -1;
	}

	public int indexOf(int number) {
		Node curNode = head;
		int i = 0;
		do {
			if (curNode.number == number) {
				return i;
			}
			curNode = curNode.nextNode;
			i++;
		} while (curNode != null);
		return -1;
	}
}
