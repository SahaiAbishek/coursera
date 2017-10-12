package coursera;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key pq[];
	private int size;

	@SuppressWarnings("unchecked")
	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(Key x) {
		pq[++size] = x;
		swim(size);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, size--);
		sink(1);
		pq[size + 1] = null;
		return max;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= size; i++) {
			sb.append(pq[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MaxPQ<String> pq = new MaxPQ<>(12);
		pq.insert("S");
		pq.insert("O");
		pq.insert("R");
		pq.insert("T");
		pq.insert("E");
		pq.insert("E");
		pq.insert("A");
		pq.insert("M");
		pq.insert("P");
		pq.insert("L");
		pq.insert("E");
		// pq.insert("S");
		pq.delMax();
		pq.delMax();
		pq.delMax();

		System.out.println(pq);
	}

}
