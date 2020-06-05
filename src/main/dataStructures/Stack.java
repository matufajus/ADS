package main.dataStructures;

public class Stack {

	private class Node {
		Object value;
		Node prevNode;

		public Node(Object value) {
			this.value = value;
		}

		public void setPrevNode(Node node) {
			prevNode = node;
		}

		public Node getPrevNode() {
			return prevNode;
		}
	}

	Node top;

	public Stack() {
		top = null;
	}

	public void push(Object object) {
		Node newNode = new Node(object);
		if (top == null) {
			top = newNode;
		} else {
			newNode.setPrevNode(top);
			top = newNode;
		}
	}

	public void pop() {
		top = top.prevNode;
	}

	public void print() {
		while (top != null) {
			System.out.println(top.value);
			top = top.prevNode;
		}
	}

}
