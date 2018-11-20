package practice;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {

	// Complete the isValid function below.
	static String isValid(String s) {

		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (charMap.get(s.charAt(i)) == null) {
				charMap.put(s.charAt(i), 1);
			} else {
				int value = charMap.get(s.charAt(i));
				charMap.put(s.charAt(i), value + 1);
			}
		}

		int highest = 0;
		int secondHighest = 0;
		int singleCharcount = 0;
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			int num = entry.getValue();
			if (num == 1) {
				singleCharcount++;
				if (singleCharcount >= 2) {
					return "NO";
				}
			}
			if (num > highest) {
				secondHighest = highest;
				highest = num;
			} else if (num > secondHighest) {
				secondHighest = num;
			}
		}

		if (highest - secondHighest > 2) {
			return "NO";
		} else {
			return "YES";
		}
	}

	public static void main(String[] args) {
		// SherlockValidString validString = new SherlockValidString();
		System.out.println(isValid("aabbccddeefghi"));
	}

}
