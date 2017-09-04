package edu.geekycamp.algorithms;

import java.util.ArrayList;

public class Sorting {
	public static <E> void print(ArrayList<E> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		for(int i = 0; i < list.size(); i++) {
			int minIndex = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			
			E minValue = list.get(minIndex);
			list.set(minIndex, list.get(i));
			list.set(i, minValue);
		}
	}
	
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		mergeSort(list, 0, list.size());
	}
	
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list, int from, int to) {
		if(from >= to - 1) {
			return;
		}
		
		if(from == to - 2) {
			if(list.get(from).compareTo(list.get(to - 1)) > 0) {
				E swap = list.get(from);
				list.set(from, list.get(to - 1));
				list.set(to - 1, swap);
			}
			return;
		}
		
		int mid = (from + to) / 2;
		
		mergeSort(list, from, mid);
		mergeSort(list, mid, to);
		merge(list, from, mid, to);
	}
	
	private static <E extends Comparable<E>> void merge(ArrayList<E> list, int from, int mid, int to) {
//		ArrayList<E> merged = new ArrayList<E>();
//		
//		int pin1 = from;
//		int pin2 = mid;
////		while(pin1 < mid || pin2 < to) {
////			if(pin2 >= to || list.get(pin1).compareTo(list.get(pin2)) < 0) {
////				merged.add(list.get(pin1));
////				pin1++;
////			} else {
////				merged.add(list.get(pin2));
////				pin2++;	
////			}
////		}
//		
//		while(pin1 < mid && pin2 < to) {
//			if(list.get(pin1).compareTo(list.get(pin2)) < 0) {
//				merged.add(list.get(pin1));
//				pin1++;
//			} else {
//				merged.add(list.get(pin2));
//				pin2++;
//			}
//		}
//		
//		while(pin1 < mid) {
//			merged.add(list.get(pin1));
//			pin1++;
//		}
//		
//		while(pin2 < to) {
//			merged.add(list.get(pin2));
//			pin2++;
//		}
//		
//		
//		
//		System.out.println("from " + Integer.toString(from));
//		System.out.println("mid " + Integer.toString(mid));
//		System.out.println("to " + Integer.toString(to));
//		System.out.println("pin1 " + Integer.toString(pin1));
//		System.out.println("pin2 " + Integer.toString(pin2));
//
////		print(merged);
//		
//		System.out.println("merged.size() " + Integer.toString(merged.size()));
//		System.out.println("to - from " + Integer.toString(to - from));
//		

		for(int i = from; i < to; i++) {
			list.set(i, new E());//merged.get(i));
		}
	}
}
