package main.exercise;

public class Palindrome {
	
	public static boolean isPalindrome(String word) {
		char[] letters = word.toCharArray();
		int n = letters.length;
		for(int i = 0; i < n/2; i++) {
			if (letters[i] != letters[n-1-i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromeWithRecursion(String word) {
		if (word.length() <= 1)
			return true;
		else {
			if (word.charAt(0) == word.charAt(word.length()-1)) {
				word = word.substring(1, word.length()-1);
				return isPalindromeWithRecursion(word);
			}else {
				return false;
			}
			
		}
	}

}
