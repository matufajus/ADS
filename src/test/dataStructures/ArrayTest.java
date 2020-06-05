package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import main.dataStructures.Array;

class ArrayTest {

	@Test
	void testRemoveDuplicates() {
		int[] a = {5, 6, 5, 3, 4, 6, 1};
		Array array = new Array(a);
		array.removeDuplicates();
		int[] b = {5, 6, 3, 4, 1};
		assertArrayEquals(b, array.toArray());	
	}

	@Test
	void testReverse() {
		int[] a = {5, 6, 5, 3, 4, 6, 1};
		Array array = new Array(a);
		array.reverse();
		int[] b = {1, 6, 4, 3, 5, 6, 5};
		assertArrayEquals(b, array.toArray());	
	}
}
