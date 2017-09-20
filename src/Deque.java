import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private class Node {
		Node prev;
		Node next;
		Item item;
	}

	private Node first, last;
	private int size = 0;

	// construct an empty deque
	public Deque() {
		first = last = null;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return (size == 0);
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Can't add null emement");
		}

		Node oldFirst = first;
		first = new Node();
		first.item = item;

		if (size == 0) {
			last = first;
		} else {
			// last.prev = first;
			first.next = oldFirst;
			oldFirst.prev = first;
		}

		size++;
	}

	// add the item to the end
	public void addLast(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Can't add null emement");
		}

		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (size == 0) {
			first = last;
		} else {
			last.prev = oldLast;
			oldLast.next = last;
		}
		size++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = first;
		}
		return item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		Item item = last.item;
		last = last.next;
		return item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return null;
	}

	// unit testing (optional)
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(2);
		deque.addFirst(1);
		deque.addLast(3);
		deque.addLast(4);

		System.out.println(deque.removeLast());
		System.out.println(deque.removeFirst());
	}
}