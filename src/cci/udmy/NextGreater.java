package cci.udmy;

import java.util.Stack;

public class NextGreater {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] retArr = new int[nums1.length];

		Stack<Integer> stack = new Stack<>();
		for (int n2 : nums2) {
			stack.push(n2);
		}
		int pos = 0;
		int arrayNum = -110;
		for (int n1 : nums1) {
			Stack<Integer> stack1 = (Stack<Integer>) stack.clone();
			boolean found = false;
			while (!stack1.isEmpty()) {
				int num = stack1.pop();
				if (n1 < num) {
					arrayNum = num;
					found = true;
				}
				if (num == n1) {
					if (!found) {
						retArr[pos] = -1;
					} else {
						retArr[pos] = arrayNum;
					}
					pos++;
					break;
				}
			}

		}
		return retArr;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 4 };
		int[] nums2 = { 1, 2, 3, 4 };
		int[] retArr = (nextGreaterElement(nums1, nums2));
		for (int n : retArr) {
			System.out.print(n + " :");
		}
	}

}
