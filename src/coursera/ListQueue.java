package coursera;

public class ListQueue<Item> {

	private class Node {
		Node next;
		Item item;
	}

	private Node first, last;

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) {
			first = last;
		}else{
			oldLast.next = last;
		}

	}

	public Item dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("empty Queue");
		}
		
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
