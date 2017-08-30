import edu.geekycamp.datastructures.Stack;
import edu.geekycamp.datastructures.Queue;
import edu.geekycamp.datastructures.LinkedList;
import edu.geekycamp.datastructures.AVL;
import edu.geekycamp.datastructures.HashTable;

import java.util.Arrays;
import java.util.List;

public class Main {
	static void testStack() {
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.println(s.isEmpty());
		
		for(int i = 1; i < 10; i++) {
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		s.push(10);
		
		try {
			System.out.println(s.pop());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void testQueue() {
		Queue<String> q = new Queue<String>();
		
		System.out.println(q.isEmpty());
		
		for(int i = 1; i < 10; i++) {
			q.push(Integer.toString(i));
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.pop());
		}
		
		q.push("10");
		
		try {
			System.out.println(q.pop());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void testLinkedList() {
		LinkedList<Double> l = new LinkedList<Double>();
		
		for(double i = 0.5; i < 10; i++) {
			l.pushBack(i);
		}
		
		l.print();
		l.pushBefore(0, new Double(0));
		l.pushBefore(6, new Double(5));
		l.print();
		l.pop(7);
		l.print();
	}
	
	static void testAVL() {
		AVL<Character> bst = new AVL<Character>();
		
		List<Character> helloWorld = Arrays.asList('h','e','l','l','o','w','o','r','l','d');
		List<Character> geekyCamp = Arrays.asList('g','e','e','k','y','c','a','m','p');
		List<Character> alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m');
		
		for(int i = 0; i < alphabet.size(); i++) {
			bst.insert(alphabet.get(i));
		}
		
		bst.print();
	}
	
	static void testHashTable() {
		HashTable<Book> map = new HashTable<Book>();
		
		Book hamlet = new Book("Hamlet", "William Shakespeare", 1987);
		Book tales = new Book("Fairy Tales", "Grimm Brothers", 2007);
		Book robinson = new Book("Robinson Crusoe", "Daniel Defoe", 1993);
		Book robinsonCopy = new Book("Robinson Crusoe", "Daniel Defoe", 1993);
		
		map.insert(hamlet);
		map.insert(tales);
		map.insert(robinson);
		
		System.out.println("Map size: " + Integer.toString(map.size()));
		System.out.println(map.contains(robinsonCopy));
	}
	
	static void testHashTable2() {
		HashTable<Book> map = new HashTable<Book>();
		
		for(int i = 0; i < 200; i++) {
			Book book = new Book("Book" + Integer.toString(i), "author", 2017);
			map.insert(book);
		}
		
		System.out.println("Map size: " + Integer.toString(map.size()));
		map.insert(new Book("Book42", "author", 2017));
		System.out.println("Map size: " + Integer.toString(map.size()));
		map.remove(new Book("Book42", "author", 2017));
		System.out.println("Map size: " + Integer.toString(map.size()));
	}
	
	public static void main(String[] args) {
//		testStack();
//		testQueue();
//		testLinkedList();
//		testAVL();
		testHashTable();
		testHashTable2();
	}
}
