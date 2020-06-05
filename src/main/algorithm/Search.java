package main.algorithm;

public class Search {

	/*
	 * Binary search is an efficient algorithm for finding an item from a sorted
	 * list of items. It works by repeatedly dividing in half the portion of the
	 * list that could contain the item, until you've narrowed down the possible
	 * locations to just one.
	 */

	// binary search using cycle
	public int binarySearch(int[] array, int element) {
		int end = array.length - 1;
		int begin = 0;
		int guess;
		while (begin <= end) {
			guess = (end + begin) / 2;
			if (array[guess] == element)
				return guess;
			else if (array[guess] > element)
				end = guess - 1;
			else
				begin = guess + 1;
		}
		return -1;
	}

	// binary search using recursive
	public int binarySearch(int[] array, int element, int l, int r) {
		if (l <= r) {
			int m = (r + l) / 2;
			if (array[m] == element) {
				return m;
			} else if (array[m] > element) {
				return binarySearch(array, element, l, m - 1);
			} else {
				return binarySearch(array, element, m + 1, r);
			}
		} else
			return -1;
	}

}
