/**
 * Try using array implementation 
 * the iterator would be random 
 * also deletions would be constant time.
 * 
 * Could get 100% too :)
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private class Node {
		Node next;
		Item item;
	}

	private class ListIterator implements Iterator<Item> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(current == null){
				throw new NoSuchElementException("No elements to show");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove not supported");
		}

	}

	private Node first, last;
	private int size;

	public RandomizedQueue() {
		first = last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return this.size;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Can't add null emement");
		}

		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty queue");
		}
		Item item = null;
		int randIndex = StdRandom.uniform(0, size);
		size--;

		// if index is 0 delete first
		if (randIndex == 0) {
			item = first.item;
			first = first.next;
			return item;
		}

		int count = 1;
		Node current = first;
		while ((count != randIndex) || current == null) {
			current = current.next;
			count++;
		}

		item = current.next.item;
		if (current.next == last) {
			last = current;
		}
		current.next = current.next.next;

		if (isEmpty()) {
			last = first;
		}

		return item;
	}

	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty queue");
		}
		Item item = null;
		int randIndex = StdRandom.uniform(0, size);
		int count = 0;
		Node current = first;
		while ((count != randIndex) || current == null) {
			current = current.next;
			count++;
		}

		item = current.item;

		return item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	public static void main(String[] args) {
		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);

		for (int i : rq) {
			System.out.print(i + ":");
		}
		
		System.out.println("\nsample = "+rq.sample());
		System.out.println("sample ="+rq.sample());
		System.out.println("deque = "+rq.dequeue());
		System.out.println("sample = "+rq.sample());
		System.out.println("deque = "+rq.dequeue());
		System.out.println("deque = "+rq.dequeue());
		System.out.println("deque = "+rq.dequeue());
//		System.out.println("deque = "+rq.dequeue());

//		Iterator<Integer> itr = rq.iterator();
//		
//		itr.next();
		
		for (int i : rq) {
			System.out.print(i + ":");
		}
	}
}