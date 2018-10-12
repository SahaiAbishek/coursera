package cci;

public class SortedStack {

	private MyStack minstack = new MyStack();
	private MyStack tempStack = new MyStack();

	public void push(int data) throws Exception {
		if (minstack.isEmpty()) {
			minstack.push(data);
		} else {
			int num = minstack.peek();
			while (num > data) {
				tempStack.push(minstack.pop());
				if(minstack.isEmpty()){
					break;
				}else{
					num = minstack.peek();
				}
			}
			minstack.push(data);
			while (!tempStack.isEmpty()) {
				minstack.push(tempStack.pop());
			}
		}
	}

	@Override
	public String toString() {
		return minstack.toString();
	}

	public static void main(String[] args) {
		SortedStack sortedStack = new SortedStack();
		try {
			sortedStack.push(2);
			sortedStack.push(20);
			sortedStack.push(5);
			sortedStack.push(1);
			System.out.println(sortedStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
