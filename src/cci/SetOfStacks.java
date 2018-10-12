package cci;

public class SetOfStacks {
	private static final int CAPACITY = 10;
	private static final int STACK_MAX_SIZE = 5;
	private int arr[][] = new int[STACK_MAX_SIZE][CAPACITY];
	private int column = 0;
	private int row = 0;

	public void push(int number) throws Exception {
		if (column == CAPACITY * STACK_MAX_SIZE) {
			throw new Exception("No more elements can be inserted");
		}
		if (column == CAPACITY) {
			row++;
			column = 0;
		}
		arr[row][column] = number;
		column++;
	}

	public int pop() throws Exception {
		if (column == 0 && row == 0) {
			throw new Exception("Empty stack");
		}

		int number = arr[row][column];
		column--;
		if (column == 0) {
			row--;
		}
		return number;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < STACK_MAX_SIZE; i++) {
			for (int j = 0; j < CAPACITY; j++) {
				sb.append(arr[i][j] + ", ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SetOfStacks stackSet = new SetOfStacks();
		try {
			stackSet.push(1);
			stackSet.push(2);
			stackSet.push(3);
			stackSet.push(4);
			stackSet.push(5);
			stackSet.push(6);
			stackSet.push(7);
			stackSet.push(8);
			stackSet.push(9);
			stackSet.push(10);
			stackSet.push(11);
			stackSet.push(12);
			stackSet.push(13);
			stackSet.push(14);
			stackSet.push(15);
			System.out.println(stackSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
