package hkr;

import java.util.Stack;

public class BalancedBracket {
	public static boolean isBalanced(String expression) {
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			switch (ch) {
			case '{':
				stk.push(ch);
				break;
			case '[':
				stk.push(ch);
				break;
			case '(':
				stk.push(ch);
				break;
			case '}':
				if (stk.size() > 0 && (stk.peek() == '{')) {
					stk.pop();
				} else {
					return false;
				}
				break;
			case ']':
				if (stk.size() > 0 && (stk.peek() == '[')) {
					stk.pop();
				} else {
					return false;
				}
				break;
			case ')':
				if (stk.size() > 0 && (stk.peek() == '(')) {
					stk.pop();
				} else {
					return false;
				}
				break;
			}
		}
		 return stk.size()==0;
//		if (stk.size() > 0) {
//			return false;
//		} else
//			return true;

	}

	public static void main(String[] args) {

		System.out.println((isBalanced("({{}}")) ? "YES" : "NO");

	}
}
