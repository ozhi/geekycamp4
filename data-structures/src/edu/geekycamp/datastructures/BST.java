package edu.geekycamp.datastructures;

/*
 * Invariant:
 * 		empty BST <=> height == 0 && left == null && right == null
 *  	non-empty BST <=> height != 0 && left != null && right != null
 *  
 * Balanced invariant:
 * 		The difference in height of two siblings is <= 1
*/

public class BST {
	private int data;
	private int height;
	private BST left, right;

	private BST(int data, BST left, BST right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = Math.max(left.height, right.height) + 1;
	}
	
	private void balance() {
		int heightDiff = left.height - right.height;

		if(heightDiff > 1) {
			BST bst1 = left.left;
			BST bst2 = left.right;
			BST bst3 = right;
			int data1 = left.data;
			int data2 = data;
			
			left = bst1;
			data = data1;
			right = new BST(data2, bst2, bst3);
		}
		
		else if(heightDiff < -1){
			BST t1 = left;
			BST t2 = right.left;
			BST t3 = right.right;
			int d1 = data;
			int d2 = right.data;
			
			left = new BST(d1, t1, t2);
			data = d2;
			right = t3;
		}
		
		height = Math.max(left.height, right.height) + 1;
	}
	
	public BST() {
		height = 0;
		left = right = null;
	}
	
	public boolean isEmpty() {
		return (height == 0);
	}
	
	public boolean contains(int value) {
		if(isEmpty()) {
			return false;
		}

		if(value == data) {
			return true;
		}
		
		return (value < data ? left : right).contains(value);
	}
	
	public void add(int value) {
		if(isEmpty()) {
			this.data = value;
			height = 1;
			left = new BST();
			right = new BST();
			return;
		}
		
		if(value == data) {
			return;
		}
		
		(value < data ? left : right).add(value);
		
		balance();
		
		this.height = Math.max(left.height, right.height) + 1;
	}
	
	public void remove(int value) {
		if(isEmpty()) {
			return;
		}
		
		if(value == data) {			
			BST higherChild = (left.height > right.height ? left : right);
			
			data = higherChild.data;
			
			if(higherChild.height == 1) {
				data = higherChild.data;
				height = 1;
				left = right = null;
				return;
			}
			
			higherChild.remove(data);
		} else {
			(value < data ? left : right).remove(value);
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
