package cci;

public class MyStack {

	private static int MAX_SIZE = 10;
	private int size;
	private int arr[] = new int[MAX_SIZE];

	public void push(int data) throws Exception {
		if (size == MAX_SIZE) {
			throw new Exception("Stack is full");
		}
		arr[size] = data;
		size++;
	}

	public int pop() throws Exception {
		if (size == 0) {
			throw new Exception("stack is Empty");
		}
		int number = arr[size-1];
		size--;
		return number;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty stack");
		}
		return arr[size-1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; i++) {
			sb.append(arr[i] + ", ");
		}
		return sb.toString();
	}
}
