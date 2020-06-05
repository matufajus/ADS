package main.dataStructures;

import java.util.HashSet;
import java.util.Set;

public class Array {

	private int[] items;

	private int count;

	public Array(int length) {
		items = new int[length];
	}

	public Array(int[] array) {
		items = array;
		count = array.length;
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			System.out.print(items[i]);
			if (i + 1 < count) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

	public void insert(int elem) {
		if (items.length == count) {
			int[] itemsNew = new int[items.length + 1];
			for (int i = 0; i < items.length; i++) {
				itemsNew[i] = items[i];
			}
			itemsNew[items.length] = elem;
			items = itemsNew;

		} else {
			items[count] = elem;
		}
		count++;
	}

	public void removeAt(int position) {
		for (int i = 0; i < count; i++) {
			if (i == count - 1) {
				items[i] = 0;
			} else if (i >= position) {
				items[i] = items[i + 1];
			}
		}
		count--;
	}

	public int indexOf() {
		return 0;
	}

	public void removeDuplicates() {
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (items[i] == items[j]) {
					removeAt(j);
					j--;
				}
			}
		}
	}

	public void reverse() {
		int temp; 
		for (int i = 0; i < count / 2; i++) {
			temp = items[i];
			items[i] = items[count - 1 - i];
			items[count - 1 - i] = temp;
		}
	}

	public int[] toArray() {
		int[] a = new int[count];
		for (int i = 0; i < count; i++) {
			a[i] = items[i];
		}
		return a;
	}
}
