import edu.geekycamp.datastructures.Stack;
import edu.geekycamp.datastructures.Queue;
import edu.geekycamp.datastructures.LinkedList;

import java.util.Arrays;
import java.util.List;

import edu.geekycamp.datastructures.BST;

public class Main {
	static void testStack() {
		Stack s = new Stack();
		
		System.out.println(s.isEmpty());
		
		for(int i = 1; i < 10; i++)
			s.push(i);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		try {
			s.pop();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void testQueue() {
		Queue q = new Queue();
		
		System.out.println(q.isEmpty());
		
		for(int i = 1; i < 10; i++)
			q.push(i);
		
		while(!q.isEmpty()) {
			System.out.println(q.pop());
		}
		
		try {
			q.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void testLinkedList() {
		LinkedList l = new LinkedList();
		
		for(int i = 1; i < 10; i++) {
			l.pushBack(i);
		}
		
		l.print();
		l.pushBefore(0, 0);
		l.pushBefore(6, 55);
		l.print();
		l.pop(7);
		l.print();
	}
	
	static void testBinarySearchTree() {
		BST bst = new BST();
		
		//List<Integer> values = Arrays.asList(5,2,8,1,4,3,7,6,9);
		//List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> values = Arrays.asList(8,4,2,1,3,6,5,7,9,10,11,12,13,14);
		
		for(int i = 0; i < values.size(); i++) {
			bst.add(values.get(i));
		}
		
		bst.print();
	}
	
	public static void main(String[] args) {
//		testStack();
//		testQueue();
//		testLinkedList();
		testBinarySearchTree();
	}
}
