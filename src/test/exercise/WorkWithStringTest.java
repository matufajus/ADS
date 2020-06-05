package test.exercise;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.exercise.WorkWithString;

class WorkWithStringTest {

	@Test
	void getFirstNonRepeatedCharUsingLinkedHashMapTest() {
		assertEquals('b', WorkWithString.getFirstNonRepeatedCharUsingHashMap("abcdefghija")); 
		assertEquals('h', WorkWithString.getFirstNonRepeatedCharUsingHashMap("hello")); 
		assertEquals('J', WorkWithString.getFirstNonRepeatedCharUsingHashMap("Java")); 
		assertEquals('i', WorkWithString.getFirstNonRepeatedCharUsingHashMap("simplest"));
	}
	

	@Test
	void getFirstNonRepeatedCharUsingSetAndListTest() {
		assertEquals('b', WorkWithString.getFirstNonRepeatedCharUsingSetAndList("abcdefghija")); 
		assertEquals('h', WorkWithString.getFirstNonRepeatedCharUsingSetAndList("hello")); 
		assertEquals('J', WorkWithString.getFirstNonRepeatedCharUsingSetAndList("Java")); 
		assertEquals('i', WorkWithString.getFirstNonRepeatedCharUsingSetAndList("simplest"));
	}
	
	@Test
	void testStringToIntConversion() {
		assertEquals(256, WorkWithString.convertStringToInt("256"));
		assertEquals(53135, WorkWithString.convertStringToInt("53135"));
		assertEquals(56, WorkWithString.convertStringToInt("0056"));
	}
}
