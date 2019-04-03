/*
 * https://leetcode.com/problems/valid-number/
 */

package lc;

public class ValidNumber {

	public static boolean isNumber(String s) {
		if (s == null) {
			return false;
		}

		s = s.trim();
		if (s.contains(" ")) {
			return false;
		}
		int numberOfDots = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (i == 0) {
				if (ch >= 'a' && ch <= 'z') {
					return false;
				}
				if (ch == '+' || ch == '-' && s.length() == 1) {
					return false;
				}
				if (ch == '+' || ch == '-' && s.charAt(i + 1) == 'e') {
					return false;
				}
				if (ch == '.' && s.length() == 1) {
					numberOfDots++;
				}
				if (ch == '.' && s.charAt(i + 1) == 'e') {
					return false;
				}
			} else {
				if (ch == '+' || ch == '-' || ch >= 'a' && ch <= 'z') {
					if (ch == 'e' && i != s.length() - 1) {
						continue;
					} else {
						return false;
					}
				}
				if (ch == '.' && s.length() - 1 == i) {
					return false;
				}
				if (ch == '.' && s.charAt(i + 1) == 'e') {
					return false;
				}
				if (ch == '.') {
					numberOfDots++;
				}
			}

			if (numberOfDots > 1) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumber("95a54e53"));
	}

}
