package test.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import main.algorithm.Sort;

class SortTest {

	@Test
	void testSelectionSort() {
		Sort sort = new Sort();
		int[] array = {5, 6, 2, 8, 3, 7, 1};
		int[] expected = {1, 2, 3, 5, 6, 7, 8};
		int[] unexpected = {5, 6, 2, 8, 3, 7, 1};
		sort.selectionSort(array);
		assertArrayEquals(expected, array);
		assertNotEquals(unexpected, array);
		
		int[] emptyArray = {};
		int[] emptyExpected = {};
		sort.selectionSort(emptyArray);
		assertArrayEquals(emptyExpected, emptyArray);
	}
	
	@Test
	void testBucketSort() {
		int[] array = {5, 16, 2, 18, 35, 7, 1};
		Sort.bucketSort(array);
		int[] expected = {1, 2, 5, 7, 16, 18, 35};
		assertArrayEquals(expected, array);
	}
	
	@Test
	void testCountSort() {
		int[] array = {5, 16, 2, 5, 18, 35, 7, 18, 1};
		array = Sort.countSort(array);
		int[] expected = {1, 2, 5, 5, 7, 16, 18, 18, 35};
		assertArrayEquals(expected, array);
	}

}
