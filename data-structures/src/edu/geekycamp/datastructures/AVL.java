package edu.geekycamp.datastructures;

/*
 * Invariant:
 * 		empty BST <=> height == 0 && left == null && right == null
 *  	non-empty BST <=> height != 0 && left != null && right != null
 *  
 * Balanced invariant:
 * 		The difference in height of two siblings is <= 1
*/

public class AVL<E extends Comparable<E>> {
	private E data;
	private int height;
	private AVL<E> left, right;

	private AVL(E data, AVL<E> left, AVL<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = Math.max(left.height, right.height) + 1;
	}
	
	private void balance() {
		int heightDiff = left.height - right.height;

		if(heightDiff > 1) {
			AVL<E> bst1 = left.left;
			AVL<E> bst2 = left.right;
			AVL<E> bst3 = right;
			E data1 = left.data;
			E data2 = data;
			
			left = bst1;
			data = data1;
			right = new AVL<E>(data2, bst2, bst3);
		}
		
		else if(heightDiff < -1){
			AVL<E> t1 = left;
			AVL<E> t2 = right.left;
			AVL<E> t3 = right.right;
			E d1 = data;
			E d2 = right.data;
			
			left = new AVL<E>(d1, t1, t2);
			data = d2;
			right = t3;
		}
		
		height = Math.max(left.height, right.height) + 1;
	}
	
	public AVL() {
		height = 0;
		left = right = null;
	}
	
	public boolean isEmpty() {
		return (height == 0);
	}
	
	public boolean contains(E value) {
		if(isEmpty()) {
			return false;
		}

		if(value == data) {
			return true;
		}
		
		return (value.compareTo(data) < 0 ? left : right).contains(value);
	}
	
	public void insert(E value) {
		if(isEmpty()) {
			this.data = value;
			height = 1;
			left = new AVL<E>();
			right = new AVL<E>();
			return;
		}
		
		if(value == data) {
			return;
		}
		
		(value.compareTo(data) < 0 ? left : right).insert(value);
		
		balance();
		
		this.height = Math.max(left.height, right.height) + 1;
	}
	
	public void remove(E value) { // NOTE: this is not he standard AVL remove
		if(isEmpty()) {
			return;
		}
		
		if(value.compareTo(data) == 0) {			
			AVL<E> higherChild = (left.height > right.height ? left : right);
			
			data = higherChild.data;
			
			if(higherChild.height == 1) {
				data = higherChild.data;
				height = 1;
				left = right = null;
				return;
			}
			
			higherChild.remove(data);
		} else if(value.compareTo(data) < 0){
			left.remove(value);
		} else if(value.compareTo(data) > 0){
			right.remove(value);
		}
		
		this.height = Math.max(left.height, right.height) + 1;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		
		left.print();
		
		for(int i = 0; i < height; i++) {
			System.out.print("      ");
		}
		
		//System.out.print("[" + Integer.toString(height) + ",");
		System.out.println(data);
		
		right.print();
	}
}
