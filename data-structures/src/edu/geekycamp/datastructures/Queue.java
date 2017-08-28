package edu.geekycamp.datastructures;

public class Queue {
	private class Node {
		public int data;
		public Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front, back;
	private int size;
	
	public Queue() {
		front = back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int getSize() {
		return size;
	}
	
	public int front() {
		if(isEmpty()) {
			throw new RuntimeException("Cannot get front: queue is empty");
		}
		
		return front.data;
	}
	
	public void push(int value) {
		Node node = new Node(value, null);
		
		size++;
		
		if(isEmpty()) {
			front = back = node;
			return;
		}
		
		back.next = node;
		back = node;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Cannot pop: queue is empty");
		}
		
		int value = front.data;
		front = front.next;
		size--;
		
		return value;
	}
}
