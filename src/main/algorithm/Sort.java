package main.algorithm;

public class Sort {

	public boolean checkIfSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * This algorithm is called selection sort because it repeatedly selects the
	 * next-smallest element and swaps it into place.
	 */
	public void selectionSort(int[] array) {
		int index, temp;
		for (int j = 0; j < array.length; j++) { // O(n^2)
			// setting first element
			index = j;
			// looking for min
			for (int i = j; i < array.length; i++) {
				if (array[i] < array[index]) {
					index = i;
				}
			}
			// swap min with first
			temp = array[j];
			array[j] = array[index];
			array[index] = temp;
		}
	}

	public void insertionSort(int[] array) {
		int j, key;
		for (int i = 1; i < array.length; i++) {
			j = i - 1;
			key = array[i];
			while ((j >= 0) && (array[j] > key)) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	public void mergeSort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);

			merge(array, l, m, r);
		}
	}

	void merge(int array[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] array1 = new int[n1];
		int[] array2 = new int[n2];

		for (int i = 0; i < n1; i++) {
			array1[i] = array[l + i];

		}
		for (int i = 0; i < n2; i++) {
			array2[i] = array[m + 1 + i];
		}

		int i = l, i1 = 0, i2 = 0;
		while (i1 < n1 && i2 < n2) {
			if (array1[i1] <= array2[i2]) {
				array[i] = array1[i1];
				i1++;
			} else {
				array[i] = array2[i2];
				i2++;
			}
			i++;
		}

		while (i1 < n1) {
			array[i] = array1[i1];
			i1++;
			i++;
		}

		while (i2 < n2) {
			array[i] = array2[i2];
			i2++;
			i++;
		}

	}

	public void quicksort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}

		int partition = partition(array, low, high);

		quicksort(array, low, partition - 1);
		quicksort(array, partition + 1, high);
	}

	private int partition(int[] array, int low, int high) {
		int temp;
		int pivot = array[high];
		int j = low - 1;
		for (int i = low; i <= high; i++) {
			if (array[i] <= pivot) {
				temp = array[j + 1];
				array[j + 1] = array[i];
				array[i] = temp;
				j++;
			}
		}
		return j;
	}

	public void bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void bucketSort(int[] array) {
		class Node {
			public int value;
			public Node next;
		}
		int n = array.length;
		Node[] buckets = new Node[n];
		int max = array[0], bucketNumber;
		// find max
		for (int number : array) {
			if (number > max) {
				max = number;
			}
		}
		for (int number : array) {
			bucketNumber = hash(number, max, n);
			Node newNode = new Node();
			newNode.value = number;
			if (buckets[bucketNumber] == null) {
				buckets[bucketNumber] = newNode;
			} else {
				Node currNode = buckets[bucketNumber];
				Node prevNode = null;
				boolean inserted = false;
				while (currNode != null) {
					if (currNode.value > newNode.value) {
						if (prevNode == null) {
							buckets[bucketNumber] = newNode;
						} else {
							prevNode.next = newNode;
						}
						newNode.next = currNode;
						inserted = true;
						break;
					}
					prevNode = currNode;
					currNode = currNode.next;
				}
				if (!inserted) {
					prevNode = newNode;
				}
			}
		}
		int i = 0;
		for (Node bucket : buckets) {
			if (bucket != null) {
				Node currNode = bucket;
				while (currNode != null) {
					array[i] = currNode.value;
					currNode = currNode.next;
					i++;
				}
			}
		}

	}

	private static int hash(int number, int max, int n) {
		return (int) (((double) number / max) * (n - 1));
	}

	public static int[] countSort(int[] array) {
		int max = array[0];
		// find max
		for (int number : array) {
			if (number > max) {
				max = number;
			}
		}
		int[] count = new int[max];
		for (int i : count) {
			i = 0;
		}
		for (int a : array) {
			count[a - 1]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}
		int[] output = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int currentNumber = array[i];
			output[count[currentNumber - 1] - 1] = currentNumber;
			count[currentNumber - 1]--;
		}
		return output;
	}

}
