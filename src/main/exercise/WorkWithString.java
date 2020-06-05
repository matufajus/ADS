package main.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WorkWithString {
	
	public static char getFirstNonRepeatedCharUsingHashMap(String input) {
		Map<Character, Integer> hashMap = new LinkedHashMap<Character, Integer>();
		for (char c : input.toCharArray()) {
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c)+1);
			}else {
				hashMap.put(c, 1);
			}
		}
		for (Entry<Character, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		throw new RuntimeException("there are no non repeated characters in string "+input);
	}
	
	public static char getFirstNonRepeatedCharUsingSetAndList(String input) {
		Set<Character> set = new HashSet<Character>();
		List<Character> list = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			if (set.contains(c)) {
				continue;
			}
			if (list.contains(c)) {
				list.remove((Character) c);
				set.add(c);
			}else {
				list.add(c);
			}
		}
		return list.get(0);
	}
	
	public static int convertStringToInt(String input) {
		int digit, number = 0, d = 1;
		for(int i = input.length()-1; i >= 0; i--) {
			digit = (int) input.charAt(i) - 48;
			if ((digit < 0) || (digit > 9))
				throw new RuntimeException("Wrong input for string to int conversion: " +input);
			number = number + digit * d;
			d = d * 10;			
		}
		return number;
	}

}
