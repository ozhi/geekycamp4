package edu.geekycamp.datastructures;

// ! class is not generic

public class Stack {
	private class Node {
		public int data;
		public Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private int size;
	private Node top;
	
	public Stack() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int getSize() {
		return size;
	}
	
	public int top() {
		if(isEmpty()) {
			throw new RuntimeException("Cannot get top: stack is empty");
		}
		
		return top.data;
	}
	
	public void push(int value) {
		Node node = new Node(value, top);
		top = node;
		size++;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Cannot pop: stack is empty");
		}
		int value = top.data;
		top = top.next;
		size--;
		return value;
	}
}
