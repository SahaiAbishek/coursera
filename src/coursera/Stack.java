package coursera;

public class Stack {

	private Node first;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty stack");
		}
		String retval = first.item;
		first = first.next;
		return retval;

	}

}
