package cci.udmy;

import java.util.Stack;

public class BaseballGame {

	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (String op : ops) {
			if (op.equals("C")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (op.equals("D")) {
				if (!stack.isEmpty()) {
					int num = stack.peek();
					stack.push(num * 2);
				}
			} else if (op.equals("+")) {
				if (!stack.isEmpty()) {
					int last = stack.pop();
					int secondLast = stack.pop();
					int current = last + secondLast;
					stack.push(secondLast);
					stack.push(last);
					stack.push(current);
				}
			} else {
				int num = new Integer(op);
				stack.push(num);
			}
		}

		for (Integer elems : stack) {
			sum += elems;
		}
		return sum;
	}

	public static void main(String[] args) {
		BaseballGame bg = new BaseballGame();
		String arr[] = { "5", "2", "C", "D", "+" };
		System.out.println(bg.calPoints(arr));

	}

}
