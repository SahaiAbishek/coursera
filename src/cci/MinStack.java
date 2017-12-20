package cci;

public class MinStack {
	private int arr[] = new int[10];
	private int min;
	private int size;

	public void push(int num) throws Exception {
		if (size == 10) {
			throw new Exception("Stack is full");
		}
		if (size == 0) {
			min = num;
		} else {
			if (num < min) {
				min = num;
			}
		}
		arr[size] = num;
		size++;
	}

	public int pop() throws Exception {
		if (size == 0) {
			throw new Exception("empty array");
		}
		size = size - 1;
		int num = arr[size];
		arr[size] = 0;
		if (num == min) {
			min = findMin();
		}

		return num;
	}

	public int findMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public int min() {
		return min;
	}

	public static void main(String[] args) throws Exception {
		MinStack stack = new MinStack();
		stack.push(20);
		stack.push(30);
		System.out.println("min = " + stack.min());
		stack.push(40);
		System.out.println("min = " + stack.min());
		stack.pop();
		System.out.println("min = " + stack.min());
	}

}
