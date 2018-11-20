package cci.udmy;

import java.util.Stack;

public class ValidParenthesis {

	public boolean checkValid(String s) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			String str = s.charAt(i) + "";
			stack.push(str);
		}
		return false;
	}

}
