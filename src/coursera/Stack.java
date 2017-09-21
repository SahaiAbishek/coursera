package coursera;

import java.util.Iterator;
import java.util.ListIterator;

public class Stack<Item> implements Iterable<Item> {

	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public Item pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty stack");
		}
		Item retval = first.item;
		first = first.next;
		return retval;

	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
